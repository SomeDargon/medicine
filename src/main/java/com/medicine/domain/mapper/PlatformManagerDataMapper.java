package com.medicine.domain.mapper;

import com.medicine.domain.User;
import com.medicine.domain.VisitRecord;
import com.medicine.domain.dto.count.CountDTO;
import com.medicine.domain.dto.count.StatementDTO;
import com.medicine.domain.dtoAndFrom.menu.FjManager;
import com.medicine.domain.menu.PlatformManagerData;
import com.medicine.domain.queryFrom.FJQueryFrom;
import com.medicine.domain.queryFrom.ZyQueryFrom;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface PlatformManagerDataMapper  extends BaseMapper<PlatformManagerData> {

    List<PlatformManagerData> selectPlatformManagerDataList(ZyQueryFrom zyQueryFrom);

    List<FjManager> findByFj(FJQueryFrom fjQueryFrom);

    List<StatementDTO> syzhCount(FJQueryFrom fjQueryFrom);

    List<StatementDTO> MedicineQuery(FJQueryFrom fjQueryFrom);

    List<CountDTO> selectCountZY(FJQueryFrom fjQueryFrom);
}
