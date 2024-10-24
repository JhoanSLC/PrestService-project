package com.finalboss_project.finalboss.utils.enums;

import io.jsonwebtoken.lang.Arrays;

public enum Rol {
    ROLE_ADMINISTRATOR(Arrays.asList(
        RolePermission.READ_ALL_APROBACIONSERVICIO,
        RolePermission.READ_ONE_APROBACIONSERVICIO,
        RolePermission.CREATE_ONE_APROBACIONSERVICIO,
        RolePermission.UPDATE_ONE_APROBACIONSERVICIO,
        RolePermission.DISABLE_ONE_APROBACIONSERVICIO,

        RolePermission.READ_ALL_CIUDAD,
        RolePermission.READ_ONE_CIUDAD,
        RolePermission.CREATE_ONE_CIUDAD,
        RolePermission.UPDATE_ONE_CIUDAD,
        RolePermission.DISABLE_ONE_CIUDAD,

        RolePermission.READ_ALL_DETALLEORDENSERVICIO,
        RolePermission.READ_ONE_DETALLEORDENSERVICIO,
        RolePermission.CREATE_ONE_DETALLEORDENSERVICIO,
        RolePermission.UPDATE_ONE_DETALLEORDENSERVICIO,
        RolePermission.DISABLE_ONE_DETALLEORDENSERVICIO,

        RolePermission.READ_ALL_DETALLEORDENTRABAJO,
        RolePermission.READ_ONE_DETALLEORDENTRABAJO,
        RolePermission.CREATE_ONE_DETALLEORDENTRABAJO,
        RolePermission.UPDATE_ONE_DETALLEORDENTRABAJO,
        RolePermission.DISABLE_ONE_DETALLEORDENTRABAJO,

        RolePermission.READ_ALL_DIRECCION,
        RolePermission.READ_ONE_DIRECCION,
        RolePermission.CREATE_ONE_DIRECCION,
        RolePermission.UPDATE_ONE_DIRECCION,
        RolePermission.DISABLE_ONE_DIRECCION,

        RolePermission.READ_ALL_EMAILPERSONA,
        RolePermission.READ_ONE_EMAILPERSONA,
        RolePermission.CREATE_ONE_EMAILPERSONA,
        RolePermission.UPDATE_ONE_EMAILPERSONA,
        RolePermission.DISABLE_ONE_EMAILPERSONA,

        RolePermission.READ_ONE_EMPRESA,
        RolePermission.READ_ALL_EMPRESA,
        RolePermission.CREATE_ONE_EMPRESA,
        RolePermission.UPDATE_ONE_EMPRESA,
        RolePermission.DISABLE_ONE_EMPRESA,

        RolePermission.READ_ALL_EMPRESASERVICIO,
        RolePermission.READ_ONE_EMPRESASERVICIO,
        RolePermission.CREATE_ONE_EMPRESASERVICIO,
        RolePermission.UPDATE_ONE_EMPRESASERVICIO,
        RolePermission.DISABLE_ONE_EMPRESASERVICIO,

        RolePermission.READ_ALL_ESTADOAPROBACION,
        RolePermission.READ_ONE_ESTADOAPROBACION,
        RolePermission.CREATE_ONE_ESTADOAPROBACION,
        RolePermission.UPDATE_ONE_ESTADOAPROBACION,
        RolePermission.DISABLE_ONE_ESTADOAPROBACION,

        RolePermission.READ_ALL_ESTADOORDENSERVICIO,
        RolePermission.READ_ONE_ESTADOORDENSERVICIO,
        RolePermission.CREATE_ONE_ESTADOORDENSERVICIO,
        RolePermission.UPDATE_ONE_ESTADOORDENSERVICIO,
        RolePermission.DISABLE_ONE_ESTADOORDENSERVICIO,

        RolePermission.READ_ALL_ESTADOORDENTRABAJO,
        RolePermission.READ_ONE_ESTADOORDENTRABAJO,
        RolePermission.CREATE_ONE_ESTADOORDENTRABAJO,
        RolePermission.UPDATE_ONE_ESTADOORDENTRABAJO,
        RolePermission.DISABLE_ONE_ESTADOORDENTRABAJO,

        RolePermission.READ_ALL_INSUMO,
        RolePermission.READ_ONE_INSUMO,
        RolePermission.CREATE_ONE_INSUMO,
        RolePermission.UPDATE_ONE_INSUMO,
        RolePermission.DISABLE_ONE_INSUMO,

        RolePermission.READ_ALL_ORDENSERVICIO,
        RolePermission.READ_ONE_ORDENSERVICIO,
        RolePermission.CREATE_ONE_ORDENSERVICIO,
        RolePermission.UPDATE_ONE_ORDENSERVICIO,
        RolePermission.DISABLE_ONE_ORDENSERVICIO,

        RolePermission.READ_ALL_ORDENTRABAJO,
        RolePermission.READ_ONE_ORDENTRABAJO,
        RolePermission.CREATE_ONE_ORDENTRABAJO,
        RolePermission.UPDATE_ONE_ORDENTRABAJO,
        RolePermission.DISABLE_ONE_ORDENTRABAJO,

        RolePermission.READ_ALL_PAIS,
        RolePermission.READ_ONE_PAIS,
        RolePermission.CREATE_ONE_PAIS,
        RolePermission.UPDATE_ONE_PAIS,
        RolePermission.DISABLE_ONE_PAIS,

        RolePermission.READ_ALL_PERSONA,
        RolePermission.READ_ONE_PERSONA,
        RolePermission.CREATE_ONE_PERSONA,
        RolePermission.UPDATE_ONE_PERSONA,
        RolePermission.DISABLE_ONE_PERSONA,

        RolePermission.READ_ALL_PERSONAINSUMO,
        RolePermission.READ_ONE_PERSONAINSUMO,
        RolePermission.CREATE_ONE_PERSONAINSUMO,
        RolePermission.UPDATE_ONE_PERSONAINSUMO,
        RolePermission.DISABLE_ONE_PERSONAINSUMO,

        RolePermission.READ_ALL_REGION,
        RolePermission.READ_ONE_REGION,
        RolePermission.CREATE_ONE_REGION,
        RolePermission.UPDATE_ONE_REGION,
        RolePermission.DISABLE_ONE_REGION,

        RolePermission.READ_ALL_SERVICIO,
        RolePermission.READ_ONE_SERVICIO,
        RolePermission.CREATE_ONE_SERVICIO,
        RolePermission.UPDATE_ONE_SERVICIO,
        RolePermission.DISABLE_ONE_SERVICIO,

        RolePermission.READ_ALL_SERVICIOINSUMO,
        RolePermission.READ_ONE_SERVICIOINSUMO,
        RolePermission.CREATE_ONE_SERVICIOINSUMO,
        RolePermission.UPDATE_ONE_SERVICIOINSUMO,
        RolePermission.DISABLE_ONE_SERVICIOINSUMO,

        RolePermission.READ_ALL_SUCURSAL,
        RolePermission.READ_ONE_SUCURSAL,
        RolePermission.CREATE_ONE_SUCURSAL,
        RolePermission.UPDATE_ONE_SUCURSAL,
        RolePermission.DISABLE_ONE_SUCURSAL,

        RolePermission.READ_ALL_TELPERSONA,
        RolePermission.READ_ONE_TELPERSONA,
        RolePermission.CREATE_ONE_TELPERSONA,
        RolePermission.UPDATE_ONE_TELPERSONA,
        RolePermission.DISABLE_ONE_TELPERSONA,

        RolePermission.READ_ALL_TIPOEMAIL,
        RolePermission.READ_ONE_TIPOEMAIL,
        RolePermission.CREATE_ONE_TIPOEMAIL,
        RolePermission.UPDATE_ONE_TIPOEMAIL,
        RolePermission.DISABLE_ONE_TIPOEMAIL,

        RolePermission.READ_ALL_TIPOEMPRESA,
        RolePermission.READ_ONE_TIPOEMPRESA,
        RolePermission.CREATE_ONE_TIPOEMPRESA,
        RolePermission.UPDATE_ONE_TIPOEMPRESA,
        RolePermission.DISABLE_ONE_TIPOEMPRESA,

        RolePermission.READ_ALL_TIPOPERSONA,
        RolePermission.READ_ONE_TIPOPERSONA,
        RolePermission.CREATE_ONE_TIPOPERSONA,
        RolePermission.UPDATE_ONE_TIPOPERSONA,
        RolePermission.DISABLE_ONE_TIPOPERSONA,

        RolePermission.READ_ALL_TIPOTELEFONO,
        RolePermission.READ_ONE_TIPOTELEFONO,
        RolePermission.CREATE_ONE_TIPOTELEFONO,
        RolePermission.UPDATE_ONE_TIPOTELEFONO,
        RolePermission.DISABLE_ONE_TIPOTELEFONO,

    )),
    ROLE_CUSTOMER(Arrays.asList(
        
    ))
    
}
