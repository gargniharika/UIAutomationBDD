@ProductSearch @Sanity
Feature: Search

Scenario Outline: 
    Given user is on home page "http://automationpractice.com/index.php"
    Then user checks if MegaMenu exists
    | MainMenu |  SubMenu         |
    | DRESSES  |  Summer Dresses  |
    When user click on SubMenu
    | MainMenu |  SubMenu         |
    | DRESSES  |  Summer Dresses  |
    Then page title should be "<ProductType>"
    When user click on Sort By: "<SortType>"
    Then Validate if product grid is sorted in "<SortType>" order
    And select Product "<productName>" with color "<color>"
    And add the item quantity "<quantity>" to Cart 
    Then Validate Product "<productName>" with Qty "<quantity>" and color "<color>" in cart
    
  Examples:
  | SortType            | ProductType    | productName          | quantity | color |
  | Price: Lowest first | Summer Dresses | Printed Summer Dress | 1        | Blue  |
  
  
  
  
 