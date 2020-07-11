package com.inputabc.ct.v1.handler.impl;

import java.io.IOException;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;

import com.inputabc.ct.v1.handler.OfflineTranslationHandler;

public class OfflineTranslationHandlerImpl implements OfflineTranslationHandler {
	@Override
	public void writeTranslatedContentToIndex(String content,String translatedContent,Directory dir){
		IndexWriter indexWriter = null;
		try {
			IndexWriterConfig indexWriterConfig = new IndexWriterConfig(new StandardAnalyzer());
			indexWriter = new IndexWriter(dir, indexWriterConfig);
			Document document = new Document();
			document.add(new StringField("content",content,Store.NO));
			document.add(new StoredField("translatedContent", translatedContent));
			indexWriter.addDocument(document);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}finally {
			if(indexWriter!=null){
				try {
					indexWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	@Override
	public String getTranslatedContentFromIndex(String content,Directory dir){
		IndexReader indexReader = null;
		try {
			indexReader = DirectoryReader.open(dir);
			IndexSearcher indexSearcher = new IndexSearcher(indexReader);
			TopDocs topDocs = indexSearcher.search(new TermQuery(new Term("content",content)), 1);
			int totalHits = topDocs.totalHits;
			if(totalHits>0){
				int docID = topDocs.scoreDocs[0].doc;
				Document document = indexSearcher.doc(docID);
				return document.get("translatedContent");
			}else{
				return null;//索引库中没有收录该content
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			if(indexReader!=null){
				try {
					indexReader.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
}
