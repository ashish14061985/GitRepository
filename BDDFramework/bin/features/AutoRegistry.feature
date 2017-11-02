#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template

Feature: AutoRegistry Website Search
	
Scenario: Browsing AutoRegistry website
Given Open Firefox Browser
When Go to AutoRegistry Website
	Then Verify browser navigates to website correctly
	

Scenario: Verify Number of AU domain registered
Given Number of registered AU domains
When  Verify on Big Dark grey Section on home page at bottom
Then Number of reigstered AU domains should be > 3 millions

Scenario: Dynamic panel on right side of the page appears
Given Dynamic panel on right side of home page
When Moveover mouse to dynamic panel on right side
Then Check Availability page option should appear

@tag4
Scenario: Click on Check Availability Page option
Given Check Availability page option appears 
When Click on Check availability page
Then Verify it navigates to next page correctly 

@tag5
Scenario: Search domain testautomation.com.au on next page
Given Search option available
When Enter domain name “testautomation.com.au" in search box
Then validate domain results showing correctly

@tag6
Scenario: Search domain test‐automation.org.au on next page
Given Search option available
When Enter domain name “testautomation.org.au" in search box
Then validate domain results showing correctly


@tag7
Scenario: Find a Registrar page option on right panel
Given Dynamic Panel on right side of the page
When Moveover mouse to dynamic panel on right side
Then Verify Find a registrar option apears 


@tag8
Scenario: Navigate through Find a Registrar page
Given Find a registrar page option
When Click on Find a registrar page
Then Verify it navigates correctly to next page

@tag9
Scenario: find your domain section on page
Given Control moves to next page
When click on find a registrar option
Then Verify find a domain text appears on page

@tag10
Scenario: Count number of external links
Given find your domain section
When External links appears on page
Then count total number of external links 

@tag11
Scenario: Click Learn More button Below Find your Domain Section
Given Learn more button appears
When click on learn more button
Then it navigates to next page correctly

@tag12
Scenario: Verify Contact Us on become a Registrar page
Given Find a registrar text appears 
When click on contact us option from header of the page
Then verify contact number appears on next page

@tag13
Scenario: Verify Email and Phone number available on page
Given Find a registrar text appears 
When click on contact us option from header of the page
Then verify email address appears on next page


