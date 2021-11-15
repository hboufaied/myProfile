Feature: Profile Creation

	@first
	Scenario: Should return a bad request when data are invalid 
		When I make a Post call on /api/profiles
		Then I should receive 400 response status code
		And I should receives the detail of errors
		
	@Second
	Scenario: Should create a new profile for valid data
		Given user wants to create a employee with the following attributes
		  | firstName | lastName | birthDate  | profileTitle |
      | John      | Doe      | 13/11/2000 | Developper   |
		And with the following address of profile
      | city    | region    | country |
      | my city | my region | France  |
    And with the following experiences of profile
      | company_city | company_region | company_country | company_name | experience-title | experience_type |
      | Paris 7      | my region      | France          | Wemanity     | Tech Lead        | FULL_TIME       |
		When I add a new valid profile on /api/profiles
		Then I should receive 201 response status code
		And the profile is created