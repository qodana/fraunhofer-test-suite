// Copyright 2025, JetBrains. This work is licensed under CC BY-NC-ND 4.0.
package jb_sast_suite.lambdas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.function.Function;

public class TestBasic2 {
  public static void test(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String taint = request.getHeader("value");
    String a = taint;
    String b = "safe";

    Function<String, String> f = (x) -> x == taint ? "safe" : taint;

    response.getWriter().println(f.apply(a));
    response.getWriter().println(f.apply(b)); //Inspection: Uncontrolled user input is passed to Cross-Site Scripting (XSS) sink
  }
}
