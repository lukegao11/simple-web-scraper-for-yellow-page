# Simple web scraper for yellowpages.com
This is a simple web scraper that can fetch search info from yellowpages.com.

To use it, you need to manually search on the website, then copypaste the url in the createCsvDataSimple function.

It will return a csv file that contains the search result name, phone number and open status.

**Limitation:**

This scraper does not consider open status other than 'OPEN NOW' and 'CLOSE NOW'. For example, if the status of a row is 'OPEN 24 HOURS' or not provided, there will be null value in the csv file.
