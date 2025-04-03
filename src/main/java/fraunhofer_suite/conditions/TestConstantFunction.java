// Copyright 2025, JetBrains. All rights reserved.
package fraunhofer_suite.conditions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestConstantFunction {
  public void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");

    if (filter()) {
      response.getWriter().println(taint); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
    }
    else {
      response.getWriter().println(taint);
    }
  }

  private boolean filter() {
    return true;
  }
}