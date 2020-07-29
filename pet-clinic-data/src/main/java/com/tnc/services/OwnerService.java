package com.tnc.services;

import com.tnc.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findLastName(String lastName);
}
