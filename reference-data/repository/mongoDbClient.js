const mongoClient=require('mongodb').MongoClient;

const refData=require('../config/ref-data.js');

//Exposed to Service calls
var mongoDbClient;

// DB Connection URL - Read from configuration file
const dbUrl = 'mongodb://localhost:27017';

// Database Name
const dbName = 'mongoDb-metallica-refData';

function removeCollection(collectionName,callback){
    mongoDbClient.collection(collectionName).remove(callback);
}

function insertDocuments (collectionName,objectArray) {
    const collection = mongoDbClient.collection(collectionName);
    collection.insertMany(objectArray, function(err, result) {
        console.log("Inserted ",result.ops.length," documents into the collection");
    });
}

module.exports={
    getMongoDb:function(){
        return mongoDbClient;
    }
    ,
    connectToMongoDb : function (callback) {
        mongoClient.connect(dbUrl,function(err,client){
            console.log("Connected successfully to Mongo Db server");
            mongoDbClient=client.db(dbName);
            callback();
        });
    }
    ,
    populateDatabase:function (){
        for (const key in refData) {
            removeCollection(key,function(){
                insertDocuments(key,refData[key]);
            });   
        }
    }
};
