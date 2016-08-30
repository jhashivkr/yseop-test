package com.icg.mongodb;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDbOperations {
	
	public static void main(String [] args){
		MongoClient client = new MongoClient("dockerhost", 8181);
		MongoDatabase db = client.getDatabase("oasis");
		
		db.createCollection("OASIS");
		MongoCollection<Document> coll = db.getCollection("OASIS");
		
		
		Document doc = new Document("name", "Test").append("type", "database").append("count", 1).append("info", new BasicDBObject("x", 203).append("y", 102));
		coll.insertOne(doc);
		
		client.close();
	}

}
