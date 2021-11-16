# networkFramework

#### About the framework
networkFramework is an HTTP networking library written in Java by Ahmed Ehab,
the framework supports HTTP request types such as (GET, POST, PUT, DELETE).


#### Download & Installation
To get the framework into your project:
Step 1. Add the JitPack repository to your build file,
Add it in your root build.gradle at the end of repositories:

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.AhmedEhab1:networkFramework:Tag'
	}
  
  #### Usage
  
  Step 3. Add the following function into a thread
  
        new NetworkConnect(JSON_URL , "GET").setCustomEventListener(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    getData(response.toString());
                                }

                                @Override
                                public void onError(IOException error) {

                                }
                            });
                            
   Step 4. Change JSON_URL with your api url, and "GET" with the desired method
        
Author
---
Ahmed Ehab, 
If you wish to contact me, email at: ahmed.ehababdelnaby@gmail.com
                            
