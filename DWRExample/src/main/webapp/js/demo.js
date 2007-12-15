function update() {
  var name = dwr.util.getValue("demoName");
  //alert(name);
  Demo.sayHello(name, function(data) {
    dwr.util.setValue("demoReply", data);
  });
}

function forward() {
  Demo.getInclude(function(data) {
    dwr.util.setValue("forward", data, { escapeHtml:false });
  });
}
