package cn.edu.sustech.zxc.booking.util;


import net.dongliu.requests.RawResponse;
import net.dongliu.requests.Session;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

import net.dongliu.requests.Requests;

public class LoginUtil {
    private static final String loginURL = "https://cas.sustech.edu.cn/cas/login";

    public static boolean login(String username, String password) {
        Session session = Requests.session();
        String response = session.get(loginURL).send().readToText();
        Document doc = Jsoup.parse(response);
        Elements inputs = doc.getElementsByTag("input");
        Map<String, Object> params = new HashMap<>();
        for (Element input : inputs) {
            String name = input.attr("name");
            String value = input.attr("value");
            params.put(name, value);
        }
        params.put("username", username);
        params.put("password", password);
        params.put("_eventId", "submit");
        RawResponse resp = session.post(loginURL).params(params).send();

        return resp.readToText().contains("Log In Successful");
    }
}
