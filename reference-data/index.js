const app=require('express')();
const logger = require('morgan');

const mongoDb=require('./repository/mongoDbClient');
const connectToEureka=require('./service-registry/eureka');
const commodity=require('./routes/commodity');
const location=require('./routes/location');
const counterparty=require('./routes/counterparty');


//Connect to MongoDB & Populate the Database with Defaults ref data
mongoDb.connectToMongoDb(function(){
    mongoDb.populateDatabase();
});


// Connecting to Eureka Server
connectToEureka();

//Middlewares
app.use(logger('dev'));
app.use('/commodity',commodity);
app.use('/location',location);
app.use('/counterparty',counterparty);

//Start App Server
app.listen(8081,()=> console.log('Reference data service listining on 3000 port...'))