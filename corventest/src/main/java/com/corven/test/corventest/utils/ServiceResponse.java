package com.corven.test.corventest.utils;

import com.corven.test.corventest.model.Person;

public class ServiceResponse {
    private String errorDescription;

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    private String operationType;

    public Person getPerson() {
        return _person;
    }

    public void setPerson(Person _person) {
        this._person = _person;
    }

    private Person _person;

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String _errDesc) {
        this.errorDescription = _errDesc;
    }






}
