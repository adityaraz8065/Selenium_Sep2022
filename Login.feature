@Login
Feature: Login Functionality
@Sanity
Scenario: Verify user is able to login with valid credentials

Given If user is on home page
When Click on Login link
And Enter Login credentials
Then Verify Logout link

@Regression @Sanity
Scenario: Verify Receive QR-code payment
Given If user is on home page
When  Click on Login link
And   Enter Login credentials
And   Click on Receive QR-code payment link
And   Enter Amount
And   Click on Next button
Then  Verify QR code and URL
