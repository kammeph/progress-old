package com.progress.strengthvalue;

import java.util.List;

import com.progress.db.ServiceBase;

public interface StrengthValueService extends ServiceBase<StrengthValue, Long> {
    List<StrengthValue> getByUser(Long userid);
}
