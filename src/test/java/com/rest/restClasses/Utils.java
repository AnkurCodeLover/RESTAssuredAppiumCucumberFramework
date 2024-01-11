package com.rest.restClasses;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {


    static RequestSpecification req;
    static String token = "526ce8f2c9d384c01e014af15b21576aab46d1d1e02a2fcb6052431e98660456";
        public static RequestSpecification requestSpecificationBuild() throws IOException
        {

            if(req==null)
            {
                PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
                req=new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addHeader("Authorization", "Bearer " + token)
                        .addFilter(RequestLoggingFilter.logRequestTo(log))
                        .addFilter(ResponseLoggingFilter.logResponseTo(log))
                        .setContentType(ContentType.JSON).build();
                return req;
            }
            return req;

        }

        public static String getGlobalValue(String key) throws IOException
        {
            Properties prop =new Properties();
            FileInputStream fis =new FileInputStream("src/test/java/com/rest/global.properties");
            prop.load(fis);
            return prop.getProperty(key);



        }


        public static String getJsonPath(Response response, String key)
        {
            String resp=response.asString();
            //System.out.println("Json String Value >>>>>>>>> "+resp);
            JsonPath   js = new JsonPath(resp);
            return js.get(key).toString();
        }
}

