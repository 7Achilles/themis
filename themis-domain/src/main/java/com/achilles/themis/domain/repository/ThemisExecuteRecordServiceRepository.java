package com.achilles.themis.domain.repository;

import com.achilles.themis.domain.entity.ThemisNodeRecord;
import org.springframework.lang.NonNull;

public interface ThemisExecuteRecordServiceRepository {

    ThemisNodeRecord save(@NonNull ThemisNodeRecord record);


}
