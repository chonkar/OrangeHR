Feature: Verify login feature

 @Smoke
  Scenario Outline: Validate successful login into the system 
    # data driven with excel sheet
    Given user is present on login page
    And title of login page is Login
    When user enters userID and Password from given sheetname "<SheetName>" and rownumber <RowNumber>
    And user clicks on login button
    Then user is on home page

    Examples: 
      | SheetName    | RowNumber |
      | LoginDetails |         0 |
      | LoginDetails |         1 |
      | LoginDetails |         2 |
      | LoginDetails |         3 |

      
    