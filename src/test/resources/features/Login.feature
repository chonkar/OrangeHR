Feature: Verify login feature

  @Smoke
  Scenario Outline: Validate successful login into the system 
    # data driven with excel sheet
    Given user is present on login page
    And title of login page is Login
    When user enters userID and Password from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User checks Terms and Condition checkbox
    And user clicks on login button
    Then user is on home page

    Examples: 
      | SheetName    | RowNumber |
      | LoginDetails |         0 |


  @Smoke
  Scenario Outline: Validate login into the system with invalid credentials
    # data driven with excel sheet
    Given user is present on login page
    And title of login page is Login
    When user enters userID and Password from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User checks Terms and Condition checkbox
    And user clicks on login button
    Then user should get an error message

    Examples: 
      | SheetName    | RowNumber |
      | LoginDetails |         1 |
      
      
  @Smoke
  Scenario Outline: Validate successful Logout from the system 
    # data driven with excel sheet
    Given user is present on login page
    And title of login page is Login
    When user enters userID and Password from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User checks Terms and Condition checkbox
    And user clicks on login button
    Then user is on home page

    Examples: 
      | SheetName    | RowNumber |
      | LoginDetails |         0 |

