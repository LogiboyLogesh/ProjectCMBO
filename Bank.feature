@BANK
Feature: Bank Master Functional Testing

  # Maker
  @BANK @SMOKE
  Scenario: Bank Master Screen Validation
    
    Given Login application using Again Maker Login
    Given clear the draft records of "Bank" in database
    And clear the pending records of "Bank" in database
    And clear existing records in bank master
    When the user clicks master menu
    And the user clicks bank master
    Then the user should see the bank master page

  @BANK
  Scenario: Validate Create a Record in Maker for Pending Actions
    
    #Given the user clicks Master menu
    #And the user clicks bank master
    When the user enters values in the respective bank fields for pendingactions
    And the user clicks save button
    Then the user validate the record saved for approval message

  @BANK
  Scenario: Validate Create a Record in Maker for Draft
    #Given the user clicks Master menu
    #And the user clicks bank master
    When the user enters values in the respective bank fields for draft
    And the user clicks saveasdraft button
    And the user validate the draft saved successfully message
    And the user clicks draft button
    And the user clicks edit button in draft page
    And the user clicks save button
    Then the user validate the record saved for approval message

  @BANK
  Scenario: Validate Record Update in Pending Actions
    #Given the user clicks Master menu
    #And the user clicks bank master
    When the user clicks pending actions
    And the user enters bank vaild text in search at pending actions
    And the user clicks preview button in pending actions
    And the user clicks edit button
    And the user changes values in the respective bank pending actions fields
    And the user clicks save button
    Then the user validate the record saved for approval message

  # Checker
  @BANK
  Scenario: Validate CheckerUser Reject a Record With Reason in Pending Actions
    Given Login application using Checker Login
    And the user clicks master menu
    And the user clicks bank master
    When the user clicks pending actions
    And select others pending record in bank master"UpdatePendingRecord"
    And the user clicks Reject button
    And the user enters reason
    And the user clicks Submit button
    Then the user should validate Record rejected successfully message
    And the user clicks x button in pending actions

  @BANK
  Scenario: Validate CheckerUser Approve a Record in Pending Actions
    #Given the user clicks Master menu
    #And the user clicks bank master
    When the user clicks pending actions
    And select others pending record in bank master"Approve"
    And the user clicks Approve button in checker
    Then the user should validate Record approved successfully message
    And the user clicks x button in pending actions

  # Both
  

  @BANK
  Scenario: Validate Record saved for approval Message
    Given Login application using Both Login
    And the user clicks master menu
    And the user clicks bank master
    When the user enters values in the bank fields for both user
    And the user clicks save button
    And the user validate the record saved for approval message
    
    @BANK
  Scenario: Validate All Mandatory Fields Changed in Global Search
    #Given Login application using Both Login
    #And the user clicks master menu
    #And the user clicks bank master
    When the user enters valid text in bank global search
    And the user double clicks on a record in bank global search
    And the user clicks edit button
    And the user changes all values in the respective bank global search fields
    And the user clicks save button
    Then the user validate the record saved for approval message

  @BANK
  Scenario: Validate BothUser Create a Record From Rejected Records Page
    #Given Login application using Both Login
    #Given the user clicks Master menu
    #And the user clicks bank master
    When the user clicks pending actions
    And the user clicks bank rejected records checkbox
    And the user enters bank rejected record in search at pending actions
    And the user clicks preview button in pending actions
    And the user clicks edit button
    And the user changes all values in the respective bank rejected record search fields
    And the user clicks save button
    And the user validate the record saved for approval message

  @BANK
  Scenario: Validate a Record in Advanced Search Page
    #Given the user clicks Master menu
    #And the user clicks bank master
    When the user clicks advancedsearch button
    And the user enters all vaild details in bank master advanced search page
    And the user clicks search button
    Then the user should validate bank advanced search page records
    And the user clicks x button in advanced search page

  @BANK @SMOKE
  Scenario: Close bank Master
    And the user close bank master tab
