package com.itheima;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.LongField;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.search.NumericRangeQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.similarities.DFRSimilarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

public class IndexManager {

	@Test
	public void testAddIndex() throws Exception {
//		1��ִ���������Ŀ¼
		Directory  directory = FSDirectory.open(new File("D:\\java\\111111111\\index"));
		
//		2��ָ���ִ���  --��׼�ִ���
		Analyzer analyzer = new IKAnalyzer();
		
//		3������һ�����ö���
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, analyzer);
//		4������һ�� д����������
		IndexWriter indexWriter = new IndexWriter(directory, config);
		
//		5��д�������
		File files = new File("D:\\java\\����\\��Ŀ\\lucene��һ��\\Lucene&solr-day01\\����\\�Ͽ��õĲ�ѯ����searchsource");
		File[] listFiles = files.listFiles();
		for (File file : listFiles) {
			Document doc = new Document();
//			�ļ�����
			Field  fileNameField = new TextField("name", file.getName(), Store.YES);
			doc.add(fileNameField);
//			�ļ�·��
			Field  filePathField = new StoredField("path", file.getPath()); 
			doc.add(filePathField);
//			�ļ���С  ��λ b
			long sizeOf = FileUtils.sizeOf(file);
			Field  fileSizeField = new LongField("size", sizeOf, Store.YES);
			doc.add(fileSizeField);
//			�ļ�����
			String fileContent = FileUtils.readFileToString(file);
			Field  fileContentField = new TextField("content", fileContent, Store.NO);
			doc.add(fileContentField);
			
			indexWriter.addDocument(doc);
		}

//		6���ر�IndexWriter����
		indexWriter.close();
		
		
	}
	
	/**
	 * ɾ��
	 * @throws Exception
	 */
	@Test
	public void testDeleteIndex() throws Exception {
		
//		1��ָ���������Ŀ¼
		Directory  directory = FSDirectory.open(new File("D:\\class39\\indexRespo1"));
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
		IndexWriter indexWriter = new IndexWriter(directory, config);
		indexWriter.deleteAll();
//		indexWriter.deleteAll();  ���ã���������
		
//		indexWriter.deleteDocuments(new Term("name", "apache"));
		
//		indexWriter.commit();
		indexWriter.close();
	}
	
	
	/**
	 * ����
	 * @throws Exception
	 */
	@Test
	public void testUpdateIndex() throws Exception {
		
//		1��ָ���������Ŀ¼
		Directory  directory = FSDirectory.open(new File("D:\\class39\\indexRespo1"));
		IndexWriterConfig config = new IndexWriterConfig(Version.LATEST, new IKAnalyzer());
		IndexWriter indexWriter = new IndexWriter(directory, config);
		
		Document doc = new Document();
		
		TextField nameField = new TextField("name", "�Լ���IndexWriterConfigһ��������ӵ�һ���ĵ�spring",Store.YES);
		nameField.setBoost(15);
		doc.add(nameField);
//		doc.add(new StoredField("path", "d://sdsds"));
//		doc.add(new LongField("size", 100l,Store.YES));
//		doc.add(new StringField("content", "�Լ���ӵ�һ���ĵ��Լ���ӵ�һ���ĵ��Լ���ӵ�һ���ĵ�",Store.NO));
				
		
//		���ʣ��Ȳ�ѯ  - ɾ�� - �滻
		indexWriter.addDocument(doc);
		
//		indexWriter.commit();
		indexWriter.close();
	}
	
	
	
	@Test
	public void testSearchIndex() throws IOException, Exception {
//		1��ָ���������Ŀ¼
		Directory  directory = FSDirectory.open(new File("D:\\java\\111111111\\frame"));

//		2������һ����ȡ��������
		IndexReader  indexReader = DirectoryReader.open(directory);
		
//		3������һ�����������Ķ���
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);

		//4��ִ��term��ѯ
//		Query query = new TermQuery(new Term("name", "spring"));
//		Query query = new MatchAllDocsQuery();
		
//		�ִʺ��ѯ
//		QueryParser queryParser = new QueryParser("name", new IKAnalyzer());
//		Query query = queryParser.parse("spring is a project");
		
//		QueryParser queryParser = new MultiFieldQueryParser(new String[] {"name","content"}, new IKAnalyzer());
//		Query query = queryParser.parse("spring is a project");
		
		
//		�ļ���С����  B
	Query query = NumericRangeQuery.newLongRange("size", 100l, 1000l, false, true);
		
//		BooleanQuery query = new BooleanQuery();
//		Query query1 = new TermQuery(new Term("content", "spring"));
//		Query query2 = new TermQuery(new Term("name", "spring"));
//		query.add(query1, Occur.SHOULD);
//		query.add(query2, Occur.MUST_NOT);  //or   and
		
		
		
		System.out.println("��ѯ�﷨��"+query);
		
		TopDocs topDocs = indexSearcher.search(query, 100);
		System.out.println("��������"+topDocs.totalHits);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int docId = scoreDoc.doc;
			Document doc = indexSearcher.doc(docId);
			System.out.println(doc.get("name"));
//			System.out.println(doc.get("size"));
//			System.out.println(doc.get("path"));
//			System.out.println(doc.get("content"));
//			System.out.println("----------------------------------------------");
		}
		
//		5���ر���Դ
		indexReader.close();
	}
	
	
	@Test
	public void testAnalyzer() throws Exception {
		
//		ë����
		
//		Analyzer analyzer = new StandardAnalyzer();
//		Analyzer analyzer = new ChineseAnalyzer(); 
//		C J K
//		Analyzer analyzer = new CJKAnalyzer();
//		Analyzer analyzer = new SmartChineseAnalyzer();
		Analyzer analyzer = new IKAnalyzer();
		
//		StandardAnalyzer:���ĵķִ� һ����һ����
//		ChineseAnalyzer����ʱ��
//		CJKAnalyzer:������������  ��Ҫ���� lucene-analyzers-smartcn-4.10.3.jar
//		SmartChineseAnalyzer: ���Ļ�����ԣ�Ӣ�Ļ��������ĸ����� ��Ҫ���� lucene-analyzers-smartcn-4.10.3.jar
		
		
//		String str = "The Spring Framework provides a comprehensive programming and configuration model.";
		String str = "���ǲ��ͣ�MyBatis ����apache��һ����Դ��ĿiBatis,���ֹ� 2010�������Ŀ��apache software foundation Ǩ�Ƶ���google code�����Ҹ���ΪMyBatis--by �����ɾ� ë����";
		
		TokenStream tokenStream = analyzer.tokenStream("test", str);
		
		tokenStream.reset();  //����ָ��
//		���һ������ �ַ���
		CharTermAttribute addAttribute = tokenStream.addAttribute(CharTermAttribute.class);
		
		while(tokenStream.incrementToken()) {
			System.out.println(addAttribute);
		}
	}
	
	/**
	 * ɾ��
	 * @throws Exception
	 */
	@Test
	public void testDelete() throws Exception {
		Directory  directory = FSDirectory.open(new File("D:\\java\\111111111\\frame"));
		
		IndexWriterConfig arg1=new IndexWriterConfig(Version.LATEST,new IKAnalyzer());
		
		IndexWriter index=new IndexWriter(directory, arg1);
		
//		index.deleteDocuments(new Term("name","apache"));
		
		index.deleteAll();
		
		index.close();
	}
	/**
	 * ��ѯ
	 * @throws Exception
	 */
	@Test
	public void testQuery() throws Exception {
//		1��ָ���������Ŀ¼
		Directory  directory = FSDirectory.open(new File("D:\\java\\111111111\\index"));

//		2������һ����ȡ��������
		IndexReader  indexReader = DirectoryReader.open(directory);
		
//		3������һ�����������Ķ���
		IndexSearcher indexSearcher = new IndexSearcher(indexReader);
		//�����ѯ
//		Query query=NumericRangeQuery.newLongRange("size", 1L, 100L, true, true);
//		BooleanQuery query=new BooleanQuery();
//		Query query1=new TermQuery(new Term("name","spring"));
//		Query query2=new TermQuery(new Term("content","spring"));
//		//must : �������     ����mustΪand�Ĺ�ϵ
//		//SHOULD : ���Գ��֣����Բ�����  ����SHOULDΪor�Ĺ�ϵ
//		//MUST_NOT : �����Գ���    ����MUST_NOT����ͬʱ����   ������ѯ�������   ���ǲ��ᱨ��
//		query.add(query1,Occur.MUST_NOT);
//		query.add(query2,Occur.MUST);
//		Query query=new MatchAllDocsQuery();
		QueryParser queryparse=new QueryParser("name",new IKAnalyzer());
		
		Query query = queryparse.parse("spring is a product");
		
		System.out.println("��ѯ�﷨��"+query);
		
		TopDocs topDocs = indexSearcher.search(query, 100);
		System.out.println("��������"+topDocs.totalHits);
		ScoreDoc[] scoreDocs = topDocs.scoreDocs;
		for (ScoreDoc scoreDoc : scoreDocs) {
			int docId = scoreDoc.doc;
			Document doc = indexSearcher.doc(docId);
			System.out.println(doc.get("name"));
			System.out.println(doc.get("size"));
			System.out.println(doc.get("path"));
			System.out.println(doc.get("content"));
			System.out.println("----------------------------------------------");
		}
	}
}
