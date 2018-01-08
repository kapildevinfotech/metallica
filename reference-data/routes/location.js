const router=require('express').Router();

const refDataService= require('../services/RefDataService');

router.get('/', function (req, res,next) {
    refDataService.getAllLocation(function (err,results){
        if(err){
            res.status(500).send({error:'Unable to fetch locations'});
        }else{
            res.header({'Access-Control-Allow-Origin': '*'});
            res.send(results);
        }
    });
})

module.exports = router