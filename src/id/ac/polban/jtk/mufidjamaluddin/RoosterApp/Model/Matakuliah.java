/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Model;

/**
 *
 * @author mufidjamaluddin
 */
public class Matakuliah 
{
    private String kode_mk;
    private String nama_mk;
    private Boolean jenis_mk;

    /**
     * @return the kode_mk
     */
    public String getKode_mk() {
        return kode_mk;
    }

    /**
     * @param kode_mk the kode_mk to set
     */
    public void setKode_mk(String kode_mk) {
        this.kode_mk = kode_mk;
    }

    /**
     * @return the nama_mk
     */
    public String getNama_mk() {
        return nama_mk;
    }

    /**
     * @param nama_mk the nama_mk to set
     */
    public void setNama_mk(String nama_mk) {
        this.nama_mk = nama_mk;
    }

    /**
     * @return the jenis_mk
     */
    public Boolean getJenis_mk() {
        return jenis_mk;
    }

    /**
     * @param jenis_mk the jenis_mk to set
     */
    public void setJenis_mk(Boolean jenis_mk) {
        this.jenis_mk = jenis_mk;
    }
}
