package com.finalboss_project.finalboss.servicioInsumo.mapper;

import com.finalboss_project.finalboss.servicioInsumo.domain.entity.ServicioInsumo;
import com.finalboss_project.finalboss.servicioInsumo.domain.entity.ServicioInsumoPk;
import com.finalboss_project.finalboss.servicioInsumo.dto.ServicioInsumoDto;

public class ServicioInsumoMapper {

    public static ServicioInsumoDto toDto(ServicioInsumo servicioInsumo) {
        ServicioInsumoDto dto = new ServicioInsumoDto();
        dto.setInsumoId(servicioInsumo.getId().getInsumoId());
        dto.setServicioId(servicioInsumo.getId().getServicioId());
        dto.setValorUnitario(servicioInsumo.getValorUnitario());
        dto.setStock(servicioInsumo.getStock());
        dto.setStockMin(servicioInsumo.getStockMin());
        dto.setStockMax(servicioInsumo.getStockMax());
        return dto;
    }

    public static ServicioInsumo toEntity(ServicioInsumoDto dto) {
        ServicioInsumoPk id = new ServicioInsumoPk(dto.getInsumoId(), dto.getServicioId());
        ServicioInsumo servicioInsumo = new ServicioInsumo();
        servicioInsumo.setId(id);
        servicioInsumo.setValorUnitario(dto.getValorUnitario());
        servicioInsumo.setStock(dto.getStock());
        servicioInsumo.setStockMin(dto.getStockMin());
        servicioInsumo.setStockMax(dto.getStockMax());
        return servicioInsumo;
    }

}
