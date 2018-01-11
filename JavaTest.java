package com.pch.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

public class JavaTest {

    List<String> myArrayList = new ArrayList<String>();

    @Before
    public void setup() {
        myArrayList.add("Chrome");
        myArrayList.add("FireFox");
        myArrayList.add("IE");
        myArrayList.add("Safari");
        myArrayList.add("Chrome");
    }

    /**
     * Testing general Java String function knowledge
     */

    @Test
    public void funWithJavaStrings() {

        String companyName = "Dom & Tom Inc.";
        // Assert that the word 'Dom' is present in companyName string
        if ( companyName.contains("Dom")) {
            System.out.println("Keyword is present");
        } else {
            System.out.println("Keyword is not present");
        }

        String name1 = "Netflix";
        String name2 = "NETFLIX";
        // Assert that name1 equals name2 regardless of case and leading/trailing spaces
        if (name1.trim().equalsIgnoreCase(name2.trim())) {
            System.out.println("Names are equal");
        } else {
            System.out.println("Names are not equal");
        }

        String intValue1 = "100";
        String intValue2 = "20";
        // Convert the above 2 strings to integer values and display the sum
        int sum = Integer.parseInt(intValue1) + Integer.parseInt(intValue2);
        System.out.println(sum);
    }

    /**
     * Testing knowledge of java Lists. The list 'myArrayList' has already been
     * created and populated in @before method. Follow steps outlined below.
     */

    @Test
    public void funWithArrayLists() {

        // Step 1 display the number of elements in myArrayList
        System.out.println(myArrayList.size());

        // Step 2 using enhanced for-loop loop thru myArrayList and display all values to console
        for (String browser : myArrayList)
            System.out.println(browser);

        // Step 3 Display the 3rd element in myArrayList
        System.out.println(myArrayList.get(2));

        /**
         * Step 4 Loop thru myArrayList to determine if any elements value = 'IE'
         * if yes, display 'IE found @ index' and the index number in the  console then exit the loop
         */
        String value = "IE";
        for (String browser : myArrayList) {
            if (browser.equals(value)) {
                int index = myArrayList.indexOf(value);
                System.out.println("IE found @ index " + index);
                break;
            }
        }

        /**
         * Step 5 Loop thru myArrayList to determine if any list elements value = 'Opera'
         * if not , display 'Opera not found'
         */
        if(!myArrayList.contains("Opera")) {
            System.out.println("Opera not found");
        }
    }

    /**
     * Testing knowledge of java HashMaps Follow steps outlined below
     */

    @Test
    public void funWithHashMaps() {

        HashMap<Integer, String> myHashMap = new HashMap<Integer, String>();

        /*
         * Step 1 Load the following into ' myHashMap'
         *
         * Key: = 1 Value: = "XP"
         * Key: = 2 Value: = "WIN7"
         * Key: = 3 Value: = "WIN8"
         */
        myHashMap.put(1,"XP");
        myHashMap.put(2,"WIN7");
        myHashMap.put(3,"WIN8");

        // Step 2 Display to console the value associated with key 2
        System.out.println(myHashMap.get(2));

        // Step 3 Display the number of elements in myHashMap
        System.out.println(myHashMap.size());

        // Step 4 Remove the last element in myHashMap and display the number of elements in myHashMap
        int lastKey = 0;
        for (Map.Entry<Integer, String> entry : myHashMap.entrySet()) {
            lastKey = entry.getKey();
        }
        myHashMap.remove(lastKey);
        System.out.println(myHashMap.size());
    }

    /**
     * Testing knowledge of calling and processing a RESTFUL WebService call using Apache HttpClient
     * Follow the steps outlined below
     * @throws IOException
     * @throws ClientProtocolException
     */

    @Test
    public void funWithWebServices() throws ClientProtocolException, IOException {
        String webServiceUrl = "http://api.geonames.org/cities?north=44.1&south=-9.9&east=-22.4&west=55.2&username=demo";

        // Step 1 Create instance of httpClient
        HttpClient client = HttpClientBuilder.create().build();;

        /*
         * Step 2 Create the Get Request, call it myGetRequest using the HttpGet
         * class and webServiceUrl
         */
        HttpGet myGetRequest = new HttpGet(webServiceUrl);

        /*
         * Step 3 Using the httpClient object created in step 1 execute
         * myGetRequest and save the HttpResponse to myHttpResponse
         */
        HttpResponse myHttpResponse = client.execute(myGetRequest);

        // Step 4 Using myHttpResponse display the statuscode and ReasonPhrase to console
        System.out.println(myHttpResponse.getStatusLine());

        /*******EXTRA CREDIT ******
         * Process the myHttpResponse and display the JSON to the console
         * ...hint the response content is returned in myHttpResponse.getEntity().getContent()
         * use BufferedReader
         */

        BufferedReader rd = new BufferedReader
                (new InputStreamReader(
                        myHttpResponse.getEntity().getContent()));

        String line = "";
        StringBuffer sb = new StringBuffer();
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        System.out.println(sb);
    }

    /**
     * Testing knowledge of java HashSets Follow steps outlined below
     *
     */
    @Test
    public void funWithHashSets() {

        // * Step 1 Create a HashSet of String objects called myHashSet
        Set<String> myHashSet = new HashSet<String>();

        /*
         * Step 2 add the following String objecta to myHashSet "XP" "WIN7"
         * "WIN8" "Safari" "XP"
         */
        myHashSet.add("XP");
        myHashSet.add("WIN7");
        myHashSet.add("WIN8");
        myHashSet.add("Safari");
        myHashSet.add("XP");

        /*
         * Step 3 Display to console all the values of myHashSet ... hint use iterator
         */
        myHashSet.forEach(System.out::println);

        // Step 4 Remove from myHashSet where String = 'XP"
        myHashSet.remove("XP");

        // Step 5 Display to console the number of elements in myHashSet
        System.out.println(myHashSet.size());

    }
}