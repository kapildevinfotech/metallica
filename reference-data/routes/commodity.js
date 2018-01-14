const router=require('express').Router();

const refDataService= require('../services/RefDataService');

router.get('/', function (req,res,next) {
    refDataService.getAllCommodity(function (err,results){
        if(err){
            res.status(500).send({error:'Unable to fetch commodity'});
        }else{
            res.send(results);
        }
    });
})

module.exports = router