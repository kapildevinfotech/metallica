var app = require('express')();
var httpServer = require('http').Server(app);
var io = require('socket.io')(httpServer);

const queue = 'notifications-metallica';
 
const open = require('amqplib').connect('amqp://localhost');

open.then(function(conn){
    return conn.createChannel();
}).then(function(ch){
    return ch.assertQueue(queue).then(function(ok){
                return ch.consume(queue,
                    msg=>processMesage(msg),
                {noAck:true});
    });
});
 
function processMesage(notification){
    const msg=notification.content.toString();
    const notificationType=notification.properties.headers['notification-type'];
    console.log(notificationType,' ',msg);

    var eventType; 
    if(notificationType.startsWith('TRADE')){
        eventType='trade';
    }else if (notificationType.starstWith('MARKET-DATA')){
        eventType='marketData';
    }
    io.sockets.emit(eventType,msg);
}

app.get('/', function(req, res){
    res.sendFile(__dirname + '/index.html');
});
   
io.on('connection', function(socket){
    socket.on('trade', function(msg){
      io.emit('trade', msg);
    });
    socket.on('marketData', function(msg){
        io.emit('marketData', msg);
      });
  });

httpServer.listen(8082, function(){
    console.log('listening on *:8082');
});
