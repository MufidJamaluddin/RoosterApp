/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Controller;

import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Dao.GenericDao;
import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Dao.IDao;
import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Model.Dosen;
import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Model.Jadwal;
import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Model.JadwalDosen;
import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Model.Jdwl_klh;
import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Model.Kelas;
import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Model.Matakuliah;
import id.ac.polban.jtk.mufidjamaluddin.RoosterApp.Model.Ruang;
import java.util.List;

/**
 *
 * @author mufidjamaluddin
 */
public class RoosterController 
{
    /**
     * Instance dari class ini
     */
    private static final RoosterController INSTANCE = new RoosterController();
    /**
     * Mendapatkan Instans
     * @return 
     */
    public static RoosterController getInstance()
    {
        return INSTANCE;
    }
    
    /**
     * Atribut
     */
    private final IDao<Jdwl_klh> daoJadwalKlh;
    private final IDao<JadwalDosen> daoJadwalDosen;
    private final IDao<Dosen> daoDosen;
    private final IDao<Jadwal> daoJadwal;
    private final IDao<Matakuliah> daoMatakuliah;
    private final IDao<Ruang> daoRuang;
    private final IDao<Kelas> daoKelas;
    
    /**
     * Konstruktor
     */
    public RoosterController()
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/rooster";
        String jdbcUsername = "root";
        String jdbcPassword = "";
        
        this.daoJadwalKlh = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Jdwl_klh.class);
        this.daoJadwalDosen = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, JadwalDosen.class);
        this.daoDosen = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Dosen.class);
        this.daoJadwal = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Jadwal.class);
        this.daoMatakuliah = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Matakuliah.class);
        this.daoRuang = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Ruang.class);
        this.daoKelas = new GenericDao<>(jdbcURL, jdbcUsername, jdbcPassword, Kelas.class);
    }
    
    /**
     * Mendapatkan List Jadwal Kuliah
     * @param kelas
     * @return 
     */
    public List<Jdwl_klh> getListJadwalKuliah(String kelas)
    {
        List<Jdwl_klh> listJdwl = this.daoJadwalKlh.getList("nama_kelas", kelas);
        return listJdwl;
    }
    
    /**
     * Mendapatkan List Jadwal Dosen Berdasarkan NIDK
     * @param nidk
     * @return 
     */
    public List<JadwalDosen> getListJadwalDosen(String nidk)
    {
        List<JadwalDosen> listJdwl = this.daoJadwalDosen.executeProcedure("jdwlDosen", nidk);
        return listJdwl;
    }
    
    /**
     * Mendapatkan List Dosen Jam Terkecil
     * @param limit
     * @return 
     */
    public List<Dosen> getListJTDosen(String limit)
    {
        List<Dosen> list = this.daoDosen.executeProcedure("jamTerkecil", limit);
        return list;
    }
    
    /**
     * Mendapatkan List Dosen
     * @return 
     */
    public List<Dosen> getListDosen()
    {
        List<Dosen> list = this.daoDosen.getList("", "");
        return list;
    }

    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Tambah Dosen
     * @param dosen
     * @return 
     */
    public String addNewDosen(Dosen dosen)
    {
        int created = this.daoDosen.create(dosen);
        
        if(created < 1)
            return "Gagal Menambahkan Dosen " + dosen.getKode_dosen();
        else
            return "Sukses Menambahkan Dosen " + dosen.getKode_dosen();
    }
    
    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Edit
     * @param dosen
     * @return 
     */
    public String editDosen(Dosen dosen)
    {
        int edited = this.daoDosen.edit(dosen, "kode_dosen", dosen.getKode_dosen());
        
        if(edited < 1)
            return "Gagal Edit Dosen " + dosen.getKode_dosen();
        else
            return "Sukses Edit Dosen " + dosen.getKode_dosen();
    }
    
    /**
     * Delete Dosen Berdasarkan NIDK
     * @param nidk 
     * @return 
     */
    public String deleteDosen(String nidk)
    {
        int deleted = this.daoDosen.delete("kode_dosen", nidk);
        
        if(deleted < 1)
            return "Gagal Menghapus Dosen " + nidk;
        else
            return "Sukses Menghapus Dosen " + nidk;
    }
    
    /**
     * 
     * @return 
     */
    public List<Matakuliah> getListMatakuliah()
    {
        List<Matakuliah> list = this.daoMatakuliah.getList("", "");
        return list;
    }
    
    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Tambah Matakuliah
     * @param matakuliah
     * @return 
     */
    public String addNewMatakuliah(Matakuliah matakuliah)
    {
        int created = this.daoMatakuliah.create(matakuliah);
        
        if(created < 1)
            return "Gagal Menambahkan Matakuliah " + matakuliah.getKode_mk();
        else
            return "Sukses Menambahkan Matakuliah " + matakuliah.getKode_mk();
    }
    
    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Edit
     * @param obj
     * @return 
     */
    public String editMatakuliah(Matakuliah obj)
    {
        int edited = this.daoMatakuliah.edit(obj, "kode_mk", obj.getKode_mk());
        
        if(edited < 1)
            return "Gagal Edit Matakuliah " + obj.getKode_mk();
        else
            return "Sukses Edit Matakuliah " + obj.getKode_mk();
    }
    
    /**
     * Delete Matakuliah Berdasarkan Kode Matakuliah 
     * @param kode_mk
     * @return 
     */
    public String deleteMatakuliah(String kode_mk)
    {
        int deleted = this.daoMatakuliah.delete("kode_mk", kode_mk);
        
        if(deleted < 1)
            return "Gagal Menghapus Matakuliah " + kode_mk;
        else
            return "Sukses Menghapus Matakuliah " + kode_mk;
    }
    
    
    /**
     * 
     * @return 
     */
    public List<Ruang> getListRuang()
    {
        List<Ruang> list = this.daoRuang.getList("", "");
        return list;
    }
    
    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Tambah Ruang
     * @param ruang
     * @return 
     */
    public String addNewRuang(Ruang ruang)
    {
        int created = this.daoRuang.create(ruang);
        
        if(created < 1)
            return "Gagal Menambahkan Ruang " + ruang.getKode_ruangan();
        else
            return "Sukses Menambahkan Ruang " + ruang.getKode_ruangan();
    }
    
    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Edit
     * @param obj
     * @return 
     */
    public String editRuang(Ruang obj)
    {
        int edited = this.daoRuang.edit(obj, "kode_ruangan", obj.getKode_ruangan());
        
        if(edited < 1)
            return "Gagal Edit Ruang " + obj.getKode_ruangan();
        else
            return "Sukses Edit Ruang " + obj.getKode_ruangan();
    }
    
    /**
     * Delete Ruang Berdasarkan Kode Ruangan
     * @param kode_ruangan
     * @return 
     */
    public String deleteRuang(String kode_ruangan)
    {
        int deleted = this.daoRuang.delete("kode_ruangan", kode_ruangan);
        
        if(deleted < 1)
            return "Gagal Menghapus Matakuliah " + kode_ruangan;
        else
            return "Sukses Menghapus Matakuliah " + kode_ruangan;
    }
    
    /**
     * 
     * @return 
     */
    public List<Kelas> getListKelas()
    {
        List<Kelas> list = this.daoKelas.getList("", "");
        return list;
    }
    
    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Tambah Ruang
     * @param kelas
     * @return 
     */
    public String addNewKelas(Kelas kelas)
    {
        int created = this.daoKelas.create(kelas);
        
        if(created < 1)
            return "Gagal Menambahkan Ruang " + kelas.getNama_kelas();
        else
            return "Sukses Menambahkan Ruang " + kelas.getNama_kelas();
    }
    
    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Edit
     * @param obj
     * @return 
     */
    public String editKelas(Kelas obj)
    {
        int edited = this.daoKelas.edit(obj, "nama_kelas", obj.getNama_kelas());
        
        if(edited < 1)
            return "Gagal Edit Kelas " + obj.getNama_kelas();
        else
            return "Sukses Edit Kelas " + obj.getNama_kelas();
    }
    
    /**
     * Delete Ruang Berdasarkan Kode Ruangan
     * @param nama_kelas
     * @return 
     */
    public String deleteKelas(String nama_kelas)
    {
        int deleted = this.daoKelas.delete("nama_kelas", nama_kelas);
        
        if(deleted < 1)
            return "Gagal Menghapus Matakuliah " + nama_kelas;
        else
            return "Sukses Menghapus Matakuliah " + nama_kelas;
    }
    
    /**
     * Mendapatkan Pesan Ketika Berhasil/Gagal Tambah Jadwal
     * @param jadwal
     * @return 
     */
    public String addJadwal(Jadwal jadwal)
    {
        int created = this.daoJadwal.create(jadwal);
        
        if(created < 1)
            return "Gagal Menambahkan Jadwal Baru";
        else
            return "Sukses Menambahkan Jadwal Baru";
    }
    
    /**
     * 
     * @param jadwal
     * @param params
     * @return 
     */
    public String editJadwal(Jadwal jadwal, String... params)
    {
        int created = this.daoJadwal.editM(jadwal, params);
        
        if(created < 1)
            return "Gagal Edit Jadwal ";
        else
            return "Sukses Edit Jadwal ";
    }
    
    /**
     * 
     * @param params
     * @return 
     */
    public String deleteJadwal(String... params)
    {
        int created = this.daoJadwal.deleteM(params);
        
        if(created < 1)
            return "Gagal Menghapus Jadwal ";
        else
            return "Sukses Menghapus Event ";
    }
}
