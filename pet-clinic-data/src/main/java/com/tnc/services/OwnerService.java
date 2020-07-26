package com.tnc.services;

import com.tnc.model.Owner;
import org.springframework.stereotype.Service;

@Service
public interface OwnerService extends CrudService<Owner, Long> {
    Owner findLastName(String lastName);
}
