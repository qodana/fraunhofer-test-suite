// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.lambdas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Function;

public class TestConditionalLambda2 {
  public static void test(HttpServletRequest request, HttpServletResponse response, boolean condition) throws IOException {
    String taint = request.getHeader("value");
    String a = taint;

    Function<String, String> f1 = (x) -> x;
    Function<String, String> f2 = (x) -> x.equals(taint) ? "safe" : taint;
    Function<String, String> f = condition ? f1 : f2;

    String b = f.apply(a);
    response.getWriter().println(b); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}
