
Feature: Request Quotation Functionality
  Scenario Outline: Submit request quotation for different vehicles
    Given I am on the Request Quotation page
    When I fill the "Breakdown Cover" with "<BreakdownCover>"
    And I select "<WindscreenRepair>" for "Windscreen Repair"
    And I enter "<Incidents>" in the "Incidents" field
    And I enter "<Registration>" in the "Registration" field
    And I enter "<AnnualMileage>" in the "Annual Mileage" field
    And I enter "<EstimatedValue>" in the "Estimated Value" field
    And I select "<ParkingLocation>" for Parking Location
    And I select "<StartOfPolicyYear>", "<StartOfPolicyMonth>", "<StartOfPolicyDay>" for Start of Policy
    And I submit the request for quotation
    Then I should see a quotation generated
    When I click the "Save Quotation" button
    Then I should see a message confirming the quotation has been saved
    And I store the quotation ID for later retrieval

    Examples:
      | BreakdownCover | WindscreenRepair | Incidents | Registration | AnnualMileage | EstimatedValue | ParkingLocation     | StartOfPolicyYear | StartOfPolicyMonth | StartOfPolicyDay |
      | Roadside       | No               | 0       | ABC123       | 12000         | 15000          | Driveway/Carport    | 2014              | February           | 7                |
      | European       | Yes              | 1      | XYZ789       | 5000          | 5000           | Locked Garage       | 2015              | March              | 1                |
      | At home        | No               |2      | DEF456       | 30000         | 25000          | Public Place        | 2014              | April              | 2                |
      | No cover       | Yes              |0    | GHI012       | 20000         | 18000          | Private Property    | 2014              | May                | 3                |
      | Roadside       | No               | 1      | JKL345       | 15000         | 12000          | Street/Road         | 2016              | June               | 4                |
