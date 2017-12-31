const Eureka = require('eureka-js-client').Eureka;

function connectToEureka() {      
    
    const eurekaClient = new Eureka({
        cwd: `${process.cwd()}/config`,
      });

    eurekaClient.start(function(error) {
        console.log(JSON.stringify(error) || 'Eureka registration complete'); 
    });
}

module.exports=connectToEureka;