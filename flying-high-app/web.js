var gzippo = require('gzippo');
var express = require('express');
var app = express();
 
app.use(gzippo.staticGzip("" + __dirname + "/dist"));
app.listen(process.env.VCAP_APP_PORT || 3000);
