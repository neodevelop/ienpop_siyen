package com.example;

import java.io.IOException;

import javax.servlet.ServletException;

import org.directwebremoting.WebContext;
import org.directwebremoting.WebContextFactory;

public class Demo {
	public String sayHello(String name) {
		return "Hello, " + name;
	}

	public String getInclude() throws ServletException, IOException {
		WebContext wctx = WebContextFactory.get();
		return wctx.forwardToString("/forward.jsp");
	}
}