const mongoDbClient=require('../repository/mongoDbClient');
const refData=require('../config/ref-data.js');

class RefDataService{

    getAllCommodity(callback){
       const documentName=Object.keys(refData)[0];
       findDocuments(documentName,callback);
    }

    getAllLocation(callback){
        const documentName=Object.keys(refData)[1];
        findDocuments(documentName,callback);
    }

    getAllCounterparty(callback){
        const documentName=Object.keys(refData)[2];
        console.log(documentName);
        findDocuments(documentName,callback);
    }
}

function findDocuments(documentName,callback){
    const collection = mongoDbClient.getMongoDb().collection(documentName);
        collection.find({}).toArray(function(err, docs) {
         console.log(docs);
         callback(null,docs);
      });
}

module.exports=new RefDataService();