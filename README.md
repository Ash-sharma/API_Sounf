# API_Sounf
Test Cases-
1-	GET request to  https://api.nasa.gov/planetary/sounds without any parameters
a.	Input- 
i.	no parameters provided 
b.	Output-
i.	Test Failed 
ii.	Status is forbidden on HTTP Port 403
iii.	Error message is provided specifying api_key missing,
iv.	Message is provided to get api_key form the api.nasa.gov to access.

2-	GET request to  https://api.nasa.gov/planetary/sounds with api_key parameter
a.	Input Parameters-
i.	Api_key = DEMO_KEY
b.	Ouput- 
i.	Test passed
ii.	Status is OK on HTTP Port 200.
iii.	Data was retrieved with count showing number of  data objects retrieved and result data with attributes like description, licencse, title, download duration, lst_modied stream_url, tag_list and id for each set of data.

3-	GET request to  https://api.nasa.gov/planetary/sounds with wrong api_key parameter
a.	Input parameter-
i.	Api_key= DEM_KEY
b.	Output-
i.	Failed to access data
ii.	Status is forbidden on HTTP Port 403
iii.	Error is given of invalid api_key 
iv.	Message is displayed that tells the invalid key was supplied and where to find the valid key.

4-	GET request to  https://api.nasa.gov/planetary/sounds with lower case api_key parameter
a.	Input parameter
i.	Api_key= demo_key
b.	Output-
i.	Failed to retrieve data
ii.	Status is forbidden on HTTP Port 403
iii.	Error is given invalid api_key
iv.	Message id provided to get the valid api_key from specific url and that the provided key is invalid
c.	Comments
i.	Key is case sensitive

5-	GET request to  https://api.nasa.gov/planetary/sounds with api_key parameter
a.	Input parameter-
i.	Api_key = DEMO_KEY
b.	Output-
i.	Able to retrieve data
ii.	Status is OK on HTTP Port 200.
iii.	Default count 10 was displayed  as no value for limit was provided.

6-	GET request to  https://api.nasa.gov/planetary/sounds with api_key and limit parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	limit = 20
b.	Output-
i.	Data was retrieved
ii.	Status is OK on HTTP Port 200.
iii.	Data retrieved has count 20 which is our specified limit value.
iv.	Number of data objects retrieved is 20

7-	GET request to  https://api.nasa.gov/planetary/sounds with api_key parameter but without any value for limit parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	limit = 
b.	Output-
i.	Data was not retrieved
ii.	Status is Internal Service Error on HTTP Port 500.
iii.	HTML content of the page is displayed specifying tags and css  with tags having internal server error as the text in them.
c.	Comments
i.	HTML page should not be displayed, instead message should be given as invalid limit value or no value provided for the limit parameter.

8-	GET request to  https://api.nasa.gov/planetary/sounds with api_key and limit parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	limit = 5
b.	Output-
i.	Data was retrieved
ii.	Status is OK on HTTP Port 200.
iii.	Data retrieved has count 5 which is our specified limit value.
iv.	Number of data objects retrieved is 5

9-	GET request to  https://api.nasa.gov/planetary/sounds with api_key and  string value of limit parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	limit = abc
b.	Output-
i.	Data was not retrieved
ii.	Status is Internal Service Error on HTTP Port 500.
iii.	HTML content of the page is displayed specifying tags and css with tags having internal server error as the text in them.
c.	Comments
i.	HTML page should not be displayed, instead message should be given as invalid limit value provided for the limit parameter.

10-	GET request to  https://api.nasa.gov/planetary/sounds with api_key parameter but without any value for limit parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	limit = 10c
b.	Output-
i.	Data was not retrieved
ii.	Status is Internal Service Error on HTTP Port 500.
iii.	HTML content of the page is displayed specifying tags and css with tags having internal server error as the text in them.
c.	HTML page should not be displayed, instead message should be given as invalid limit value provided for the limit parameter.

11-	GET request to  https://api.nasa.gov/planetary/sounds with api_key and limit parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	limit = 100
b.	Output-
i.	Data was retrieved
ii.	Status is OK on HTTP Port 200.
iii.	Count is provided to be 64 and 64 data objects are displayed
c.	Message should be provided with specifying the maximum number for the limit.

12-	GET request to  https://api.nasa.gov/planetary/sounds with api_key and q parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	q = Voyager 1: Three
b.	Output-
i.	Test Failed
ii.	Status is OK on HTTP Port 200.
iii.	All the default data was retrieved instead of only data which has specified string in it  with count default count 10 as we have not provided it with limit parameter.
c.	Comments
i.	Search functionality is not working as it is not able to extract specified string from the data.

13-	GET request to  https://api.nasa.gov/planetary/sounds with api_key and q parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	q = null
b.	Output-
i.	Test Failed
ii.	Status is OK on HTTP Port 200.
iii.	All the default data was retrieved instead of only data which has specified string in it with count default count 10 as we have not provided it with limit parameter.
c.	Comments
i.	Search functionality is not working as it is not able to extract specified string from the data.

14-	GET request to  https://api.nasa.gov/planetary/sounds with api_key and no value of q parameter
a.	Input parameter-
i.	api_key = DEMO_KEY
ii.	q = 
b.	Output-
i.	Test Failed
ii.	Status is OK on HTTP Port 200.
iii.	All the default data was retrieved instead of giving message for providing text to be searched and default count of 10 is displayed again as we have not provided it with limit parameter.

15-	GET request to  https://api.nasa.gov/planetary/sounds with invalid parameter 
a.	Input Parameters-
i.	Api_key = DEMO_KEY
ii.	Search = max
b.	Output 
i.	Test Failed
ii.	Status is OK on HTTP Port 200.
iii.	Data is still retrieved with default count of 10.
c.	Comments
i.	Data should not be displayed. An error message should we displayed prompting that given parameter is invalid and no such parameter exists. It should give message showing what parameters can be used for querying. 

Unexpected Issues – 
1-	When no value of limit is provided output is an HTML page showing the tags with text as internal error or the application is not able to access the information and css is displayed. Rather a proper message should be displayed providing proper error addressing to provide input value for limit parameter.
2-	Upper limit or maximum count should be specified for the limit parameter and message should be displayed if that input parameter exceeds that count.
3-	 Search parameter q is not functioning as it is meant to as all the default data is displayed irrespective of whether the value is provided or not for the parameter q.
4-	Proper error and messages should be provided for passing any parameters which are not specified by the API. 
5-	Headers should be more elaborative specifying exactly what are they meant for and what areas are they affecting.
6-	API is not well documented for anyone to thoroughly validate what type of parameters (mandatory or optional) are expected in the response.
