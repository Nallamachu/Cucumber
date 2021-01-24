package com.cucumber.stepdefs;

import com.cucumber.dto.EmployeeDTO;
import com.cucumber.dto.PhoneDTO;
import cucumber.api.DataTable;
import cucumber.api.java8.En;
import io.restassured.response.Response;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

/**
 * Step Definition Class for Employee.
 *
 * <p>Uses Java Lambda style step definitions so that we don't need to worry
 * about method naming for each step definition</p>
 */
public class EmployeeSteps extends AbstractSteps implements En {

    public EmployeeSteps() {

        Given("^user want to create an employee with following attributes$", (DataTable employeeDt) -> {
            testContext().reset();
            List<EmployeeDTO> employeeList = employeeDt.asList(EmployeeDTO.class);
            super.testContext()
                    .setPayload(employeeList.get(0));
        });

        And("with the following phone numbers", (DataTable phoneDt) -> {
            List<PhoneDTO> phoneList = phoneDt.asList(PhoneDTO.class);
            super.testContext()
                    .getPayload(EmployeeDTO.class)
                    .setPhones(phoneList);
        });

        When("^user saves the new employee 'WITH ALL REQUIRED FIELDS'$", () -> {
            String createEmployeeUrl = "/v1/employee/create";
            executePost(createEmployeeUrl);
        });

        Then("the save \"([^\"]*)\"$", (String expectedResult) -> {
            Response response = testContext().getResponse();

            switch (expectedResult) {
                case "IS SUCCESSFUL":
                    assertThat(response.statusCode()).isIn(200, 201);
                    break;
                case "FAILS":
                    assertThat(response.statusCode()).isBetween(400, 504);
                    break;
                default:
                    fail("Unexpected error");
            }
        });
    }
}
