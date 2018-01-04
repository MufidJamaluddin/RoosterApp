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
public class Jadwal 
{
    private String kode_ruangan;
    private String tanggal;
    private String jam;
    private String nama_kelas;
    private String kode_dosen;
    private String kode_mk;
    private Boolean jenis_mk;
    private String kurikulum;
    private String tahun_akademik;

    /**
     * @return the kode_ruangan
     */
    public String getKode_ruangan() {
        return kode_ruangan;
    }

    /**
     * @param kode_ruangan the kode_ruangan to set
     */
    public void setKode_ruangan(String kode_ruangan) {
        this.kode_ruangan = kode_ruangan;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * @return the jam
     */
    public String getJam() {
        return jam;
    }

    /**
     * @param jam the jam to set
     */
    public void setJam(String jam) {
        this.jam = jam;
    }

    /**
     * @return the nama_kelas
     */
    public String getNama_kelas() {
        return nama_kelas;
    }

    /**
     * @param nama_kelas the nama_kelas to set
     */
    public void setNama_kelas(String nama_kelas) {
        this.nama_kelas = nama_kelas;
    }

    /**
     * @return the kode_dosen
     */
    public String getKode_dosen() {
        return kode_dosen;
    }

    /**
     * @param kode_dosen the kode_dosen to set
     */
    public void setKode_dosen(String kode_dosen) {
        this.kode_dosen = kode_dosen;
    }

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

    /**
     * @return the kurikulum
     */
    public String getKurikulum() {
        return kurikulum;
    }

    /**
     * @param kurikulum the kurikulum to set
     */
    public void setKurikulum(String kurikulum) {
        this.kurikulum = kurikulum;
    }

    /**
     * @return the tahun_akademik
     */
    public String getTahun_akademik() {
        return tahun_akademik;
    }

    /**
     * @param tahun_akademik the tahun_akademik to set
     */
    public void setTahun_akademik(String tahun_akademik) {
        this.tahun_akademik = tahun_akademik;
    }
}
