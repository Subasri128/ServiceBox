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
@tag
Feature: Addtition of article to cart in eccommerce application
  I want to use this template for my feature file
  
  Background:
  Given I navigated to ecommerce website

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Positive test of adding article to cart
    Given Logged in <userId> , <RRDIcode> and <DOPRcode>
    When I article to cart
    And Language is changed
    Then Article added to cart

    Examples: 
      | userId  |     RRDIcode| DOPRcode  |
      | DB87049 |     XTTIAM7 | 010072Y   |
      | DB87050 |     XTTIAM1 | 010072Y   |
