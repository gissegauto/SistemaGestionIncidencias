/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import business.direccion.boundary.BarrioManager;
import business.direccion.boundary.CiudadManager;
import business.direccion.boundary.DepartamentoManager;
import business.direccion.boundary.PaisManager;
import business.direccion.entity.Barrio;
import business.direccion.entity.Ciudad;
import business.direccion.entity.Departamento;
import business.direccion.entity.Pais;
import business.utils.UtilLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.ToggleEvent;

/**
 *
 * @author ggauto
 */
@Named
@SessionScoped
public class PaisBean implements Serializable {

    private Pais pais;
    private Departamento departamento;
    private Ciudad ciudad;
    private Barrio barrio;
    private List<Pais> paisList;
    private List<Departamento> departamentoList;
    private List<Ciudad> ciudadList;
    private List<Barrio> barrioList;
    private List<Barrio> barrioListAdd;
    FacesContext context = FacesContext.getCurrentInstance();
    @Inject
    PaisManager paisMgr;
    @Inject
    DepartamentoManager departamentoMgr;
    @Inject
    CiudadManager ciudadMgr;
    @Inject
    BarrioManager barrioMgr;

    @PostConstruct
    public void init() {
        limpiar();
    }

    public void limpiar() {
        pais = new Pais();
        departamento = new Departamento();
        ciudad = new Ciudad();
        barrio = new Barrio();
        paisList = paisMgr.getAll();
        departamentoList = departamentoMgr.getAll();
        ciudadList = ciudadMgr.getAll();
        barrioList = barrioMgr.getAll();
        barrioListAdd = new ArrayList<>();
    }

    public String add() {
        if (addPais()) {
            if (addDepartamento()) {
                if (addCiudad()) {
                    if (addBarrio()) {

                        return "pais";
                    }
                }
            }
        }
        return "";
    }

    public boolean addPais() {
        try {
            if (pais != null) {
                for (Pais p : paisList) {
                    if (p.getNombre().trim().equalsIgnoreCase(pais.getNombre().trim())
                            && (pais.getIdPais() == null || pais.getIdPais() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El pais " + p.getNombre() + " ya se encuentra registrado"));
                        return false;
                    }
                }
                if (pais != null & pais.getIdPais() == null) {
                    paisMgr.add(pais);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Pais: " + pais.getNombre()));
                } else if (pais != null & pais.getIdPais() > 0) {
                    paisMgr.update(pais);
                    context.addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Pais: " + pais.getNombre()));
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el pais "));
            UtilLogger.error("Problemas al insertar el pais", e);
            return false;
        }
        return true;
    }

    public boolean addDepartamento() {
        try {
            if (departamento != null) {
                for (Departamento d : departamentoList) {
                    if (d.getDepartamento().trim().equalsIgnoreCase(departamento.getDepartamento().trim())
                            && (departamento.getIdDepartamento() == null
                            || departamento.getIdDepartamento() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El departamento " + d.getDepartamento() + " ya se encuentra registrado"));
                        return false;
                    }
                }
                if (departamento != null & departamento.getIdDepartamento() == null) {
                    departamentoMgr.add(departamento);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Departamento:" + departamento.getDepartamento()));
                } else if (pais != null & departamento.getIdDepartamento() > 0) {
                    departamentoMgr.update(departamento);
                    context.addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Departamento:" + departamento.getDepartamento()));
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el departamento "));
            UtilLogger.error("Problemas al insertar el departamento", e);
            return false;
        }
        return true;
    }

    public boolean addCiudad() {
        try {
            if (ciudad != null) {
                for (Ciudad c : ciudadList) {
                    if (c.getCiudad().trim().equalsIgnoreCase(ciudad.getCiudad().trim())
                            && (ciudad.getIdCiudad() == null
                            || ciudad.getIdCiudad() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "La ciudad " + c.getCiudad() + " ya se encuentra registrada"));
                        return false;
                    }
                }
                if (ciudad != null & ciudad.getIdCiudad() == null) {
                    ciudadMgr.add(ciudad);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Ciudad: " + ciudad.getCiudad()));
                } else if (pais != null & ciudad.getIdCiudad() > 0) {
                    ciudadMgr.update(ciudad);
                    context.addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Ciudad: " + ciudad.getCiudad()));
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar la Ciudad "));
            UtilLogger.error("Problemas al insertar la ciudad", e);
            return false;
        }
        return true;
    }

    public boolean addBarrio() {
        try {
            if (barrio != null) {
                for (Barrio b : barrioList) {
                    if (b.getBarrio().trim().equalsIgnoreCase(barrio.getBarrio().trim())
                            && (barrio.getIdBarrio() == null
                            || barrio.getIdBarrio() == 0)) {
                        context.addMessage(null, new FacesMessage("Advertencia",
                                "El barrio " + b.getBarrio()
                                + " ya se encuentra registrado"));
                        return false;
                    }
                }
                if (barrio != null & barrio.getIdBarrio() == null) {
                    barrioMgr.add(barrio);
                    context.addMessage(null, new FacesMessage("Se agregó correctamente",
                            "Barrio: " + barrio.getBarrio()));
                } else if (barrio != null & barrio.getIdBarrio() > 0) {
                    barrioMgr.update(barrio);
                    context.addMessage(null, new FacesMessage("Se actualizó correctamente",
                            "Barrio: " + barrio.getBarrio()));
                }
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el Barrio "));
            UtilLogger.error("Problemas al insertar el barrio", e);
            return false;
        }
        return true;
    }

    public String delete() {
        try {
            if (pais.getIdPais() > 0) {
                paisMgr.delete(pais);
                context.addMessage(null, new FacesMessage("Se borró el País"));
                RequestContext.getCurrentInstance().update("paisForm:dtPais");
            }
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error",
                    "Ocurrió un error al intentar guardar el país "));
            UtilLogger.error("Problemas al insertar el país ", e);
        }
        return "pais";
    }

    public void cargarBarrios() {
        if (ciudad != null && !ciudad.getCiudad().equals("")) {
            barrioList = barrioMgr.getBarriosByCiudad(ciudad);
            RequestContext.getCurrentInstance().update("form-add:dtBarrio");
        }
    }

    public void onCellEdit(CellEditEvent event) {
//        String oldValue = event.getOldValue().toString();
//        String newValue = event.getNewValue().toString();
//        Rol newRol = paisMgr.getByName(oldValue);
//        newRol.setDescripcion(newValue);
//        paisMgr.update(newRol);
//        RequestContext.getCurrentInstance().update("rolForm:dtRol");

    }

    public void actionClean(ActionEvent actionEvent) {
        this.pais = new Pais();
        RequestContext.getCurrentInstance().update("paisForm:dtPais");
    }

//    public void handleToggle(ToggleEvent event) {
//        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Pais> getPaisList() {
        return paisList;
    }

    public void setPaisList(List<Pais> paisList) {
        this.paisList = paisList;
    }

    public List<Ciudad> getCiudadList() {
        return ciudadList;
    }

    public void setCiudadList(List<Ciudad> ciudadList) {
        this.ciudadList = ciudadList;
    }

    public List<Barrio> getBarrioList() {
        return barrioList;
    }

    public void setBarrioList(List<Barrio> barrioList) {
        this.barrioList = barrioList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    public List<Departamento> getDepartamentoList() {
        return departamentoList;
    }

    public void setDepartamentoList(List<Departamento> departamentoList) {
        this.departamentoList = departamentoList;
    }

    public List<Barrio> getBarrioListAdd() {
        return barrioListAdd;
    }

    public void setBarrioListAdd(List<Barrio> barrioListAdd) {
        this.barrioListAdd = barrioListAdd;
    }

}
