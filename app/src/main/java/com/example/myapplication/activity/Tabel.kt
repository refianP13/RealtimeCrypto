package com.example.myapplication.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.R
import com.example.myapplication.adapter.bitcoinAdapter

import com.example.myapplication.api.RetrofitClient
import com.example.myapplication.modelData.crypto.AaveIdr
import com.example.myapplication.modelData.crypto.Tickers
import com.example.myapplication.modelData.crypto.aaData

import com.example.myapplication.modelData.gambar.Data
import com.example.myapplication.modelData.gambar.passingBuy

import com.example.myapplication.modelData.gambar.realData
import com.example.myapplication.modelData.gambar.srcGambarItem
import com.google.gson.Gson
import kotlin.reflect.full.memberProperties
import com.squareup.picasso.Picasso
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

import kotlin.reflect.jvm.reflect

class Tabel : AppCompatActivity() {
    lateinit var rvCrypto: RecyclerView
    var list2 = ArrayList<srcGambarItem>()
    lateinit var list4 : aaData
    var num = Array(3){Array(200){""} }
    var numSell = Array(200){""}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tabel)
        rvCrypto = findViewById(R.id.rvCrypto)
        rvCrypto.setHasFixedSize(true)
        rvCrypto.layoutManager = LinearLayoutManager(this)
        var refresh = findViewById<Button>(R.id.refresh)
        takeData()
        refresh.setOnClickListener() {
            takeData()
        }
    }
    fun takeData() {
        var k = ""
        var ex = findViewById<TextView>(R.id.ex)
        var list = arrayListOf<passingBuy>()
        //kalau array pakai ini
        RetrofitClient.instance.getDatag().enqueue(object : Callback<ArrayList<srcGambarItem>>{
            override fun onResponse(call: Call<ArrayList<srcGambarItem>>, response: Response<ArrayList<srcGambarItem>>) {
                val listkan = response?.body()
                list2 = listkan!!
            }
            override fun onFailure(call: Call<ArrayList<srcGambarItem>>, t: Throwable) {
            }
        })
        RetrofitClient.instance.getDatah().enqueue(object : Callback<aaData>{
            override fun onResponse(call: Call<aaData>, response: Response<aaData>) {
                val listyuk = response?.body()
                list4 = listyuk!!
                passingData()

                for(position in num[0].indices) {
                    val passing = passingBuy()
                    passing.harga = num[0][position]
                    passing.jual = numSell[position]
                    list.add(passing)
                }
                val adapter2 = bitcoinAdapter(list2,list)
                rvCrypto.adapter = adapter2
                adapter2.setOnclickListener(object : bitcoinAdapter.onItemClickListener{
                    override fun onItemclick(position: Int) {
                        val intent = Intent(this@Tabel,DetailCrypto::class.java)
                        intent.putExtra("nama",list2[position].description)
                        intent.putExtra("data", list2[position].trade_min_traded_currency)
                        intent.putExtra("beli",num[0][position])
                        intent.putExtra("pict", list2[position].url_logo_png)
                        intent.putExtra("jual",numSell[position])
                        startActivity(intent)
                    }
                })
            }
            override fun onFailure(call: Call<aaData>, t: Throwable) {
            }
        })
    }
    fun passingData(){
        num[0][0] = list4.tickers.btc_idr.buy
        num[0][1] = list4.tickers.ten_idr.buy
        num[0][2] = list4.tickers.component3().buy
        num[0][3] = list4.tickers.aave_idr.buy
        num[0][4] = list4.tickers.abbc_idr.buy
        num[0][5] = list4.tickers.abyss_idr.buy
        num[0][6] = list4.tickers.act_idr.buy
        num[0][7] = list4.tickers.ada_idr.buy
        num[0][8] = list4.tickers.aioz_idr.buy
        num[0][9] = list4.tickers.alice_idr.buy
        num[0][10] = list4.tickers.algo_idr.buy
        num[0][11] = list4.tickers.alpaca_idr.buy
        num[0][12] = list4.tickers.alt_idr.buy
        num[0][13] = list4.tickers.amp_idr.buy
        num[0][14] = list4.tickers.ankr_idr.buy
        num[0][15] = list4.tickers.aoa_idr.buy
        num[0][16] = list4.tickers.ata_idr.buy
        num[0][17] = list4.tickers.atom_idr.buy
        num[0][18] = list4.tickers.att_idr.buy
        num[0][19] = list4.tickers.audio_idr.buy
        num[0][20] = list4.tickers.axs_idr.buy
        num[0][21] = list4.tickers.bake_idr.buy
        num[0][22] = list4.tickers.bal_idr.buy
        num[0][23] = list4.tickers.bat_idr.buy
        num[0][24] = list4.tickers.bcd_idr.buy
        num[0][25] = list4.tickers.bch_idr.buy
        num[0][26] = list4.tickers.belt_idr.buy
        num[0][27] = list4.tickers.bnb_idr.buy
        num[0][28] = list4.tickers.bnbhedge_idr.buy
        num[0][29] = list4.tickers.bnt_idr.buy
        num[0][30] = list4.tickers.botx_idr.buy
        num[0][31] = list4.tickers.bsv_idr.buy
        num[0][32] = list4.tickers.btg_idr.buy
        num[0][33] = list4.tickers.bts_idr.buy
        num[0][34] = list4.tickers.btt_idr.buy
        num[0][35] = list4.tickers.busd_idr.buy
        num[0][36] = list4.tickers.cake_idr.buy
        num[0][37] = list4.tickers.cel_idr.buy
        num[0][38] = list4.tickers.celo_idr.buy
        num[0][39] = list4.tickers.chz_idr.buy
        num[0][40] = list4.tickers.ckb_idr.buy
        num[0][41] = list4.tickers.coal_idr.buy
        num[0][42] = list4.tickers.comp_idr.buy
        num[0][43] = list4.tickers.cfx_idr.buy
        num[0][44] = list4.tickers.coti_idr.buy
        num[0][45] = list4.tickers.cre_idr.buy
        num[0][46] = list4.tickers.cro_idr.buy
        num[0][47] = list4.tickers.crv_idr.buy
        num[0][48] = list4.tickers.ctsi_idr.buy
        num[0][49] = list4.tickers.dad_idr.buy
        num[0][50] = list4.tickers.dai_idr.buy
        num[0][51] = list4.tickers.dao_idr.buy
        num[0][52] = list4.tickers.dash_idr.buy
        num[0][53] = list4.tickers.dax_idr.buy
        num[0][54] = list4.tickers.dent_idr.buy
        num[0][55] = list4.tickers.dep_idr.buy
        num[0][56] = list4.tickers.dgb_idr.buy
        num[0][57] = list4.tickers.dgx_idr.buy
        num[0][58] = list4.tickers.doge_idr.buy
        num[0][59] = list4.tickers.dot_idr.buy
        num[0][60] = list4.tickers.dvi_idr.buy
        num[0][61] = list4.tickers.dydx_idr.buy
        num[0][62] = list4.tickers.efi_idr.buy
        num[0][63] = list4.tickers.egld_idr.buy
        num[0][64] = list4.tickers.em_idr.buy
        num[0][65] = list4.tickers.enj_idr.buy
        num[0][66] = list4.tickers.eos_idr.buy
        num[0][67] = list4.tickers.etc_idr.buy
        num[0][68] = list4.tickers.eth_idr.buy
        num[0][69] = list4.tickers.ethhedge_idr.buy
        num[0][70] = list4.tickers.eurs_idr.buy
        num[0][71] = list4.tickers.fil_idr.buy
        num[0][72] = list4.tickers.firo_idr.buy
        num[0][73] = list4.tickers.ftm_idr.buy
        num[0][74] = list4.tickers.ftt_idr.buy
        num[0][75] = list4.tickers.gala_idr.buy
        num[0][76] = list4.tickers.glch_idr.buy
        num[0][77] = list4.tickers.grt_idr.buy
        num[0][78] = list4.tickers.gsc_idr.buy
        num[0][79] = list4.tickers.gxc_idr.buy
        num[0][80] = list4.tickers.hart_idr.buy
        num[0][81] = list4.tickers.hbar_idr.buy
        num[0][82] = list4.tickers.hedg_idr.buy
        num[0][83] = list4.tickers.hedge_idr.buy
        num[0][84] = list4.tickers.hibs_idr.buy
        num[0][85] = list4.tickers.hive_idr.buy
        num[0][86] = list4.tickers.hnst_idr.buy
        num[0][87] = list4.tickers.hnt_idr.buy
        num[0][88] = list4.tickers.hot_idr.buy
        num[0][89] = list4.tickers.hpb_idr.buy
        num[0][90] = list4.tickers.idk_idr.buy
        num[0][91] = list4.tickers.ignis_idr.buy
        num[0][92] = list4.tickers.inj_idr.buy
        num[0][93] = list4.tickers.iost_idr.buy
        num[0][94] = list4.tickers.iota_idr.buy
        num[0][95] = list4.tickers.iotx_idr.buy
        num[0][96] = list4.tickers.jst_idr.buy
        num[0][97] = list4.tickers.kai_idr.buy
        num[0][98] = list4.tickers.kdag_idr.buy
        num[0][99] = list4.tickers.klay_idr.buy
        num[0][100] = list4.tickers.ksm_idr.buy
        num[0][101] = list4.tickers.let_idr.buy
        num[0][102] = list4.tickers.lgold_idr.buy
        num[0][103] = list4.tickers.link_idr.buy
        num[0][104] = list4.tickers.lland_idr.buy
        num[0][105] = list4.tickers.loom_idr.buy
        num[0][106] = list4.tickers.lrc_idr.buy
        num[0][107] = list4.tickers.lsilver_idr.buy
        num[0][108] = list4.tickers.ltc_idr.buy
        num[0][109] = list4.tickers.lyfe_idr.buy
        num[0][110] = list4.tickers.mana_idr.buy
        num[0][111] = list4.tickers.matic_idr.buy
        num[0][112] = list4.tickers.mbl_idr.buy
        num[0][113] = list4.tickers.mkr_idr.buy
        num[0][114] = list4.tickers.near_idr.buy
        num[0][115] = list4.tickers.neo_idr.buy
        num[0][116] = list4.tickers.nexo_idr.buy
        num[0][117] = list4.tickers.nrg_idr.buy
        num[0][118] = list4.tickers.nxt_idr.buy
        num[0][119] = list4.tickers.ocean_idr.buy
        num[0][120] = list4.tickers.octo_idr.buy
        num[0][121] = list4.tickers.ogn_idr.buy
        num[0][122] = list4.tickers.okb_idr.buy
        num[0][123] = list4.tickers.omg_idr.buy
        num[0][124] = list4.tickers.ont_idr.buy
        num[0][125] = list4.tickers.orbs_idr.buy
        num[0][126] = list4.tickers.orc_idr.buy
        num[0][127] = list4.tickers.oxt_idr.buy
        num[0][128] = list4.tickers.pando_idr.buy
        num[0][129] = list4.tickers.paxg_idr.buy
        num[0][130] = list4.tickers.perp_idr.buy
        num[0][131] = list4.tickers.qnt_idr.buy
        num[0][132] = list4.tickers.qtum_idr.buy
        num[0][133] = list4.tickers.ren_idr.buy
        num[0][134] = list4.tickers.rep_idr.buy
        num[0][135] = list4.tickers.rev_idr.buy
        num[0][136] = list4.tickers.rvn_idr.buy
        num[0][137] = list4.tickers.sand_idr.buy
        num[0][138] = list4.tickers.sfi_idr.buy
        num[0][139] = list4.tickers.slp_idr.buy
        num[0][140] = list4.tickers.snx_idr.buy
        num[0][141] = list4.tickers.sol_idr.buy
        num[0][142] = list4.tickers.solve_idr.buy
        num[0][143] = list4.tickers.srm_idr.buy
        num[0][144] = list4.tickers.storj_idr.buy
        num[0][145] = list4.tickers.sumo_idr.buy
        num[0][146] = list4.tickers.sushi_idr.buy
        num[0][147] = list4.tickers.sxp_idr.buy
        num[0][148] = list4.tickers.tad_idr.buy
        num[0][149] = list4.tickers.tel_idr.buy
        num[0][150] = list4.tickers.tfuel_idr.buy
        num[0][151] = list4.tickers.theta_idr.buy
        num[0][152] = list4.tickers.titan_idr.buy
        num[0][153] = list4.tickers.trx_idr.buy
        num[0][154] = list4.tickers.uma_idr.buy
        num[0][155] = list4.tickers.uni_idr.buy
        num[0][156] = list4.tickers.usdc_idr.buy
        num[0][157] = list4.tickers.usdp_idr.buy
        num[0][158] = list4.tickers.usdt_idr.buy
        num[0][159] = list4.tickers.velo_idr.buy
        num[0][160] = list4.tickers.vex_idr.buy
        num[0][161] = list4.tickers.vra_idr.buy
        num[0][162] = list4.tickers.vsys_idr.buy
        num[0][163] = list4.tickers.waves_idr.buy
        num[0][164] = list4.tickers.wbtc_idr.buy
        num[0][165] = list4.tickers.wnxm_idr.buy
        num[0][166] = list4.tickers.wozx_idr.buy
        num[0][167] = list4.tickers.xch_idr.buy
        num[0][168] = list4.tickers.xdc_idr.buy
        num[0][169] = list4.tickers.xem_idr.buy
        num[0][170] = list4.tickers.xlm_idr.buy
        num[0][171] = list4.tickers.xmr_idr.buy
        num[0][172] = list4.tickers.xrp_idr.buy
        num[0][173] = list4.tickers.xrphedge_idr.buy
        num[0][174] = list4.tickers.xsgd_idr.buy
        num[0][175] = list4.tickers.xtz_idr.buy
        num[0][176] = list4.tickers.xvs_idr.buy
        num[0][177] = list4.tickers.yfi_idr.buy
        num[0][178] = list4.tickers.yfii_idr.buy
        num[0][179] = list4.tickers.zec_idr.buy
        num[0][180] = list4.tickers.zil_idr.buy
        num[0][181] = list4.tickers.zrx_idr.buy
        num[0][182] = list4.tickers.btc_usdt.buy
        num[0][183] = list4.tickers.bear_usdt.buy
        num[0][184] = list4.tickers.bull_usdt.buy
        num[0][185] = list4.tickers.btt_usdt.buy
        num[0][186] = list4.tickers.eth_usdt.buy
        num[0][187] = list4.tickers.gard_usdt.buy
        num[0][188] = list4.tickers.kin_usdt.buy
        num[0][189] = list4.tickers.pundix_usdt.buy
        num[0][190] = list4.tickers.pxg_usdt.buy
        num[0][191] = list4.tickers.shib_usdt.buy
        num[0][192] = list4.tickers.ssp_usdt.buy
        num[0][193] = list4.tickers.xec_usdt.buy
        num[1][0] = list4.tickers.btc_idr.vol_idr
        num[1][1] = list4.tickers.ten_idr.vol_idr
        num[1][2] = list4.tickers.component3().vol_idr
        num[1][3] = list4.tickers.aave_idr.vol_idr
        num[1][4] = list4.tickers.abbc_idr.vol_idr
        num[1][5] = list4.tickers.abyss_idr.vol_idr
        num[1][6] = list4.tickers.act_idr.vol_idr
        num[1][7] = list4.tickers.ada_idr.vol_idr
        num[1][8] = list4.tickers.aioz_idr.vol_idr
        num[1][9] = list4.tickers.alice_idr.vol_idr
        num[1][10] = list4.tickers.algo_idr.vol_idr
        num[1][11] = list4.tickers.alpaca_idr.vol_idr
        num[1][12] = list4.tickers.alt_idr.vol_idr
        num[1][13] = list4.tickers.amp_idr.vol_idr
        num[1][14] = list4.tickers.ankr_idr.vol_idr
        num[1][15] = list4.tickers.aoa_idr.vol_idr
        num[1][16] = list4.tickers.ata_idr.vol_idr
        num[1][17] = list4.tickers.atom_idr.vol_idr
        num[1][18] = list4.tickers.att_idr.vol_idr
        num[1][19] = list4.tickers.audio_idr.vol_idr
        num[1][20] = list4.tickers.axs_idr.vol_idr
        num[1][21] = list4.tickers.bake_idr.vol_idr
        num[1][22] = list4.tickers.bal_idr.vol_idr
        num[1][23] = list4.tickers.bat_idr.vol_idr
        num[1][24] = list4.tickers.bcd_idr.vol_idr
        num[1][25] = list4.tickers.bch_idr.vol_idr
        num[1][26] = list4.tickers.belt_idr.vol_idr
        num[1][27] = list4.tickers.bnb_idr.vol_idr
        num[1][28] = list4.tickers.bnbhedge_idr.vol_idr
        num[1][29] = list4.tickers.bnt_idr.vol_idr
        num[1][30] = list4.tickers.botx_idr.vol_idr
        num[1][31] = list4.tickers.bsv_idr.vol_idr
        num[1][32] = list4.tickers.btg_idr.vol_idr
        num[1][33] = list4.tickers.bts_idr.vol_idr
        num[1][34] = list4.tickers.btt_idr.vol_idr
        num[1][35] = list4.tickers.busd_idr.vol_idr
        num[1][36] = list4.tickers.cake_idr.vol_idr
        num[1][37] = list4.tickers.cel_idr.vol_idr
        num[1][38] = list4.tickers.celo_idr.vol_idr
        num[1][39] = list4.tickers.chz_idr.vol_idr
        num[1][40] = list4.tickers.ckb_idr.vol_idr
        num[1][41] = list4.tickers.coal_idr.vol_idr
        num[1][42] = list4.tickers.comp_idr.vol_idr
        num[1][43] = list4.tickers.cfx_idr.vol_idr
        num[1][44] = list4.tickers.coti_idr.vol_idr
        num[1][45] = list4.tickers.cre_idr.vol_idr
        num[1][46] = list4.tickers.cro_idr.vol_idr
        num[1][47] = list4.tickers.crv_idr.vol_idr
        num[1][48] = list4.tickers.ctsi_idr.vol_idr
        num[1][49] = list4.tickers.dad_idr.vol_idr
        num[1][50] = list4.tickers.dai_idr.vol_idr
        num[1][51] = list4.tickers.dao_idr.vol_idr
        num[1][52] = list4.tickers.dash_idr.vol_idr
        num[1][53] = list4.tickers.dax_idr.vol_idr
        num[1][54] = list4.tickers.dent_idr.vol_idr
        num[1][55] = list4.tickers.dep_idr.vol_idr
        num[1][56] = list4.tickers.dgb_idr.vol_idr
        num[1][57] = list4.tickers.dgx_idr.vol_idr
        num[1][58] = list4.tickers.doge_idr.vol_idr
        num[1][59] = list4.tickers.dot_idr.vol_idr
        num[1][60] = list4.tickers.dvi_idr.vol_idr
        num[1][61] = list4.tickers.dydx_idr.vol_idr
        num[1][62] = list4.tickers.efi_idr.vol_idr
        num[1][63] = list4.tickers.egld_idr.vol_idr
        num[1][64] = list4.tickers.em_idr.vol_idr
        num[1][65] = list4.tickers.enj_idr.vol_idr
        num[1][66] = list4.tickers.eos_idr.vol_idr
        num[1][67] = list4.tickers.etc_idr.vol_idr
        num[1][68] = list4.tickers.eth_idr.vol_idr
        num[1][69] = list4.tickers.ethhedge_idr.vol_idr
        num[1][70] = list4.tickers.eurs_idr.vol_idr
        num[1][71] = list4.tickers.fil_idr.vol_idr
        num[1][72] = list4.tickers.firo_idr.vol_idr
        num[1][73] = list4.tickers.ftm_idr.vol_idr
        num[1][74] = list4.tickers.ftt_idr.vol_idr
        num[1][75] = list4.tickers.gala_idr.vol_idr
        num[1][76] = list4.tickers.glch_idr.vol_idr
        num[1][77] = list4.tickers.grt_idr.vol_idr
        num[1][78] = list4.tickers.gsc_idr.vol_idr
        num[1][79] = list4.tickers.gxc_idr.vol_idr
        num[1][80] = list4.tickers.hart_idr.vol_idr
        num[1][81] = list4.tickers.hbar_idr.vol_idr
        num[1][82] = list4.tickers.hedg_idr.vol_idr
        num[1][83] = list4.tickers.hedge_idr.vol_idr
        num[1][84] = list4.tickers.hibs_idr.vol_idr
        num[1][85] = list4.tickers.hive_idr.vol_idr
        num[1][86] = list4.tickers.hnst_idr.vol_idr
        num[1][87] = list4.tickers.hnt_idr.vol_idr
        num[1][88] = list4.tickers.hot_idr.vol_idr
        num[1][89] = list4.tickers.hpb_idr.vol_idr
        num[1][90] = list4.tickers.idk_idr.vol_idr
        num[1][91] = list4.tickers.ignis_idr.vol_idr
        num[1][92] = list4.tickers.inj_idr.vol_idr
        num[1][93] = list4.tickers.iost_idr.vol_idr
        num[1][94] = list4.tickers.iota_idr.vol_idr
        num[1][95] = list4.tickers.iotx_idr.vol_idr
        num[1][96] = list4.tickers.jst_idr.vol_idr
        num[1][97] = list4.tickers.kai_idr.vol_idr
        num[1][98] = list4.tickers.kdag_idr.vol_idr
        num[1][99] = list4.tickers.klay_idr.vol_idr
        num[1][100] = list4.tickers.ksm_idr.vol_idr
        num[1][101] = list4.tickers.let_idr.vol_idr
        num[1][102] = list4.tickers.lgold_idr.vol_idr
        num[1][103] = list4.tickers.link_idr.vol_idr
        num[1][104] = list4.tickers.lland_idr.vol_idr
        num[1][105] = list4.tickers.loom_idr.vol_idr
        num[1][106] = list4.tickers.lrc_idr.vol_idr
        num[1][107] = list4.tickers.lsilver_idr.vol_idr
        num[1][108] = list4.tickers.ltc_idr.vol_idr
        num[1][109] = list4.tickers.lyfe_idr.vol_idr
        num[1][110] = list4.tickers.mana_idr.vol_idr
        num[1][111] = list4.tickers.matic_idr.vol_idr
        num[1][112] = list4.tickers.mbl_idr.vol_idr
        num[1][113] = list4.tickers.mkr_idr.vol_idr
        num[1][114] = list4.tickers.near_idr.vol_idr
        num[1][115] = list4.tickers.neo_idr.vol_idr
        num[1][116] = list4.tickers.nexo_idr.vol_idr
        num[1][117] = list4.tickers.nrg_idr.vol_idr
        num[1][118] = list4.tickers.nxt_idr.vol_idr
        num[1][119] = list4.tickers.ocean_idr.vol_idr
        num[1][120] = list4.tickers.octo_idr.vol_idr
        num[1][121] = list4.tickers.ogn_idr.vol_idr
        num[1][122] = list4.tickers.okb_idr.vol_idr
        num[1][123] = list4.tickers.omg_idr.vol_idr
        num[1][124] = list4.tickers.ont_idr.vol_idr
        num[1][125] = list4.tickers.orbs_idr.vol_idr
        num[1][126] = list4.tickers.orc_idr.vol_idr
        num[1][127] = list4.tickers.oxt_idr.vol_idr
        num[1][128] = list4.tickers.pando_idr.vol_idr
        num[1][129] = list4.tickers.paxg_idr.vol_idr
        num[1][130] = list4.tickers.perp_idr.vol_idr
        num[1][131] = list4.tickers.qnt_idr.vol_idr
        num[1][132] = list4.tickers.qtum_idr.vol_idr
        num[1][133] = list4.tickers.ren_idr.vol_idr
        num[1][134] = list4.tickers.rep_idr.vol_idr
        num[1][135] = list4.tickers.rev_idr.vol_idr
        num[1][136] = list4.tickers.rvn_idr.vol_idr
        num[1][137] = list4.tickers.sand_idr.vol_idr
        num[1][138] = list4.tickers.sfi_idr.vol_idr
        num[1][139] = list4.tickers.slp_idr.vol_idr
        num[1][140] = list4.tickers.snx_idr.vol_idr
        num[1][141] = list4.tickers.sol_idr.vol_idr
        num[1][142] = list4.tickers.solve_idr.vol_idr
        num[1][143] = list4.tickers.srm_idr.vol_idr
        num[1][144] = list4.tickers.storj_idr.vol_idr
        num[1][145] = list4.tickers.sumo_idr.vol_idr
        num[1][146] = list4.tickers.sushi_idr.vol_idr
        num[1][147] = list4.tickers.sxp_idr.vol_idr
        num[1][148] = list4.tickers.tad_idr.vol_idr
        num[1][149] = list4.tickers.tel_idr.vol_idr
        num[1][150] = list4.tickers.tfuel_idr.vol_idr
        num[1][151] = list4.tickers.theta_idr.vol_idr
        num[1][152] = list4.tickers.titan_idr.vol_idr
        num[1][153] = list4.tickers.trx_idr.vol_idr
        num[1][154] = list4.tickers.uma_idr.vol_idr
        num[1][155] = list4.tickers.uni_idr.vol_idr
        num[1][156] = list4.tickers.usdc_idr.vol_idr
        num[1][157] = list4.tickers.usdp_idr.vol_idr
        num[1][158] = list4.tickers.usdt_idr.vol_idr
        num[1][159] = list4.tickers.velo_idr.vol_idr
        num[1][160] = list4.tickers.vex_idr.vol_idr
        num[1][161] = list4.tickers.vra_idr.vol_idr
        num[1][162] = list4.tickers.vsys_idr.vol_idr
        num[1][163] = list4.tickers.waves_idr.vol_idr
        num[1][164] = list4.tickers.wbtc_idr.vol_idr
        num[1][165] = list4.tickers.wnxm_idr.vol_idr
        num[1][166] = list4.tickers.wozx_idr.vol_idr
        num[1][167] = list4.tickers.xch_idr.vol_idr
        num[1][168] = list4.tickers.xdc_idr.vol_idr
        num[1][169] = list4.tickers.xem_idr.vol_idr
        num[1][170] = list4.tickers.xlm_idr.vol_idr
        num[1][171] = list4.tickers.xmr_idr.vol_idr
        num[1][172] = list4.tickers.xrp_idr.vol_idr
        num[1][173] = list4.tickers.xrphedge_idr.vol_idr
        num[1][174] = list4.tickers.xsgd_idr.vol_idr
        num[1][175] = list4.tickers.xtz_idr.vol_idr
        num[1][176] = list4.tickers.xvs_idr.vol_idr
        num[1][177] = list4.tickers.yfi_idr.vol_idr
        num[1][178] = list4.tickers.yfii_idr.vol_idr
        num[1][179] = list4.tickers.zec_idr.vol_idr
        num[1][180] = list4.tickers.zil_idr.vol_idr
        num[1][181] = list4.tickers.zrx_idr.vol_idr
        num[1][182] = list4.tickers.btc_usdt.vol_usdt
        num[1][183] = list4.tickers.bear_usdt.vol_usdt
        num[1][184] = list4.tickers.bull_usdt.vol_usdt
        num[1][185] = list4.tickers.btt_usdt.vol_usdt
        num[1][186] = list4.tickers.eth_usdt.vol_usdt
        num[1][187] = list4.tickers.gard_usdt.vol_usdt
        num[1][188] = list4.tickers.kin_usdt.vol_usdt
        num[1][189] = list4.tickers.pundix_usdt.vol_usdt
        num[1][190] = list4.tickers.pxg_usdt.vol_usdt
        num[1][191] = list4.tickers.shib_usdt.vol_usdt
        num[1][192] = list4.tickers.ssp_usdt.vol_usdt
        num[1][193] = list4.tickers.xec_usdt.vol_usdt
        numSell[0] = list4.tickers.btc_idr.sell
        numSell[1] = list4.tickers.ten_idr.sell
        numSell[2] = list4.tickers.component3().sell
        numSell[3] = list4.tickers.aave_idr.sell
        numSell[4] = list4.tickers.abbc_idr.sell
        numSell[5] = list4.tickers.abyss_idr.sell
        numSell[6] = list4.tickers.act_idr.sell
        numSell[7] = list4.tickers.ada_idr.sell
        numSell[8] = list4.tickers.aioz_idr.sell
        numSell[9] = list4.tickers.alice_idr.sell
        numSell[10] = list4.tickers.algo_idr.sell
        numSell[11] = list4.tickers.alpaca_idr.sell
        numSell[12] = list4.tickers.alt_idr.sell
        numSell[13] = list4.tickers.amp_idr.sell
        numSell[14] = list4.tickers.ankr_idr.sell
        numSell[15] = list4.tickers.aoa_idr.sell
        numSell[16] = list4.tickers.ata_idr.sell
        numSell[17] = list4.tickers.atom_idr.sell
        numSell[18] = list4.tickers.att_idr.sell
        numSell[19] = list4.tickers.audio_idr.sell
        numSell[20] = list4.tickers.axs_idr.sell
        numSell[21] = list4.tickers.bake_idr.sell
        numSell[22] = list4.tickers.bal_idr.sell
        numSell[23] = list4.tickers.bat_idr.sell
        numSell[24] = list4.tickers.bcd_idr.sell
        numSell[25] = list4.tickers.bch_idr.sell
        numSell[26] = list4.tickers.belt_idr.sell
        numSell[27] = list4.tickers.bnb_idr.sell
        numSell[28] = list4.tickers.bnbhedge_idr.sell
        numSell[29] = list4.tickers.bnt_idr.sell
        numSell[30] = list4.tickers.botx_idr.sell
        numSell[31] = list4.tickers.bsv_idr.sell
        numSell[32] = list4.tickers.btg_idr.sell
        numSell[33] = list4.tickers.bts_idr.sell
        numSell[34] = list4.tickers.btt_idr.sell
        numSell[35] = list4.tickers.busd_idr.sell
        numSell[36] = list4.tickers.cake_idr.sell
        numSell[37] = list4.tickers.cel_idr.sell
        numSell[38] = list4.tickers.celo_idr.sell
        numSell[39] = list4.tickers.chz_idr.sell
        numSell[40] = list4.tickers.ckb_idr.sell
        numSell[41] = list4.tickers.coal_idr.sell
        numSell[42] = list4.tickers.comp_idr.sell
        numSell[43] = list4.tickers.cfx_idr.sell
        numSell[44] = list4.tickers.coti_idr.sell
        numSell[45] = list4.tickers.cre_idr.sell
        numSell[46] = list4.tickers.cro_idr.sell
        numSell[47] = list4.tickers.crv_idr.sell
        numSell[48] = list4.tickers.ctsi_idr.sell
        numSell[49] = list4.tickers.dad_idr.sell
        numSell[50] = list4.tickers.dai_idr.sell
        numSell[51] = list4.tickers.dao_idr.sell
        numSell[52] = list4.tickers.dash_idr.sell
        numSell[53] = list4.tickers.dax_idr.sell
        numSell[54] = list4.tickers.dent_idr.sell
        numSell[55] = list4.tickers.dep_idr.sell
        numSell[56] = list4.tickers.dgb_idr.sell
        numSell[57] = list4.tickers.dgx_idr.sell
        numSell[58] = list4.tickers.doge_idr.sell
        numSell[59] = list4.tickers.dot_idr.sell
        numSell[60] = list4.tickers.dvi_idr.sell
        numSell[61] = list4.tickers.dydx_idr.sell
        numSell[62] = list4.tickers.efi_idr.sell
        numSell[63] = list4.tickers.egld_idr.sell
        numSell[64] = list4.tickers.em_idr.sell
        numSell[65] = list4.tickers.enj_idr.sell
        numSell[66] = list4.tickers.eos_idr.sell
        numSell[67] = list4.tickers.etc_idr.sell
        numSell[68] = list4.tickers.eth_idr.sell
        numSell[69] = list4.tickers.ethhedge_idr.sell
        numSell[70] = list4.tickers.eurs_idr.sell
        numSell[71] = list4.tickers.fil_idr.sell
        numSell[72] = list4.tickers.firo_idr.sell
        numSell[73] = list4.tickers.ftm_idr.sell
        numSell[74] = list4.tickers.ftt_idr.sell
        numSell[75] = list4.tickers.gala_idr.sell
        numSell[76] = list4.tickers.glch_idr.sell
        numSell[77] = list4.tickers.grt_idr.sell
        numSell[78] = list4.tickers.gsc_idr.sell
        numSell[79] = list4.tickers.gxc_idr.sell
        numSell[80] = list4.tickers.hart_idr.sell
        numSell[81] = list4.tickers.hbar_idr.sell
        numSell[82] = list4.tickers.hedg_idr.sell
        numSell[83] = list4.tickers.hedge_idr.sell
        numSell[84] = list4.tickers.hibs_idr.sell
        numSell[85] = list4.tickers.hive_idr.sell
        numSell[86] = list4.tickers.hnst_idr.sell
        numSell[87] = list4.tickers.hnt_idr.sell
        numSell[88] = list4.tickers.hot_idr.sell
        numSell[89] = list4.tickers.hpb_idr.sell
        numSell[90] = list4.tickers.idk_idr.sell
        numSell[91] = list4.tickers.ignis_idr.sell
        numSell[92] = list4.tickers.inj_idr.sell
        numSell[93] = list4.tickers.iost_idr.sell
        numSell[94] = list4.tickers.iota_idr.sell
        numSell[95] = list4.tickers.iotx_idr.sell
        numSell[96] = list4.tickers.jst_idr.sell
        numSell[97] = list4.tickers.kai_idr.sell
        numSell[98] = list4.tickers.kdag_idr.sell
        numSell[99] = list4.tickers.klay_idr.sell
        numSell[100] = list4.tickers.ksm_idr.sell
        numSell[101] = list4.tickers.let_idr.sell
        numSell[102] = list4.tickers.lgold_idr.sell
        numSell[103] = list4.tickers.link_idr.sell
        numSell[104] = list4.tickers.lland_idr.sell
        numSell[105] = list4.tickers.loom_idr.sell
        numSell[106] = list4.tickers.lrc_idr.sell
        numSell[107] = list4.tickers.lsilver_idr.sell
        numSell[108] = list4.tickers.ltc_idr.sell
        numSell[109] = list4.tickers.lyfe_idr.sell
        numSell[110] = list4.tickers.mana_idr.sell
        numSell[111] = list4.tickers.matic_idr.sell
        numSell[112] = list4.tickers.mbl_idr.sell
        numSell[113] = list4.tickers.mkr_idr.sell
        numSell[114] = list4.tickers.near_idr.sell
        numSell[115] = list4.tickers.neo_idr.sell
        numSell[116] = list4.tickers.nexo_idr.sell
        numSell[117] = list4.tickers.nrg_idr.sell
        numSell[118] = list4.tickers.nxt_idr.sell
        numSell[119] = list4.tickers.ocean_idr.sell
        numSell[120] = list4.tickers.octo_idr.sell
        numSell[121] = list4.tickers.ogn_idr.sell
        numSell[122] = list4.tickers.okb_idr.sell
        numSell[123] = list4.tickers.omg_idr.sell
        numSell[124] = list4.tickers.ont_idr.sell
        numSell[125] = list4.tickers.orbs_idr.sell
        numSell[126] = list4.tickers.orc_idr.sell
        numSell[127] = list4.tickers.oxt_idr.sell
        numSell[128] = list4.tickers.pando_idr.sell
        numSell[129] = list4.tickers.paxg_idr.sell
        numSell[130] = list4.tickers.perp_idr.sell
        numSell[131] = list4.tickers.qnt_idr.sell
        numSell[132] = list4.tickers.qtum_idr.sell
        numSell[133] = list4.tickers.ren_idr.sell
        numSell[134] = list4.tickers.rep_idr.sell
        numSell[135] = list4.tickers.rev_idr.sell
        numSell[136] = list4.tickers.rvn_idr.sell
        numSell[137] = list4.tickers.sand_idr.sell
        numSell[138] = list4.tickers.sfi_idr.sell
        numSell[139] = list4.tickers.slp_idr.sell
        numSell[140] = list4.tickers.snx_idr.sell
        numSell[141] = list4.tickers.sol_idr.sell
        numSell[142] = list4.tickers.solve_idr.sell
        numSell[143] = list4.tickers.srm_idr.sell
        numSell[144] = list4.tickers.storj_idr.sell
        numSell[145] = list4.tickers.sumo_idr.sell
        numSell[146] = list4.tickers.sushi_idr.sell
        numSell[147] = list4.tickers.sxp_idr.sell
        numSell[148] = list4.tickers.tad_idr.sell
        numSell[149] = list4.tickers.tel_idr.sell
        numSell[150] = list4.tickers.tfuel_idr.sell
        numSell[151] = list4.tickers.theta_idr.sell
        numSell[152] = list4.tickers.titan_idr.sell
        numSell[153] = list4.tickers.trx_idr.sell
        numSell[154] = list4.tickers.uma_idr.sell
        numSell[155] = list4.tickers.uni_idr.sell
        numSell[156] = list4.tickers.usdc_idr.sell
        numSell[157] = list4.tickers.usdp_idr.sell
        numSell[158] = list4.tickers.usdt_idr.sell
        numSell[159] = list4.tickers.velo_idr.sell
        numSell[160] = list4.tickers.vex_idr.sell
        numSell[161] = list4.tickers.vra_idr.sell
        numSell[162] = list4.tickers.vsys_idr.sell
        numSell[163] = list4.tickers.waves_idr.sell
        numSell[164] = list4.tickers.wbtc_idr.sell
        numSell[165] = list4.tickers.wnxm_idr.sell
        numSell[166] = list4.tickers.wozx_idr.sell
        numSell[167] = list4.tickers.xch_idr.sell
        numSell[168] = list4.tickers.xdc_idr.sell
        numSell[169] = list4.tickers.xem_idr.sell
        numSell[170] = list4.tickers.xlm_idr.sell
        numSell[171] = list4.tickers.xmr_idr.sell
        numSell[172] = list4.tickers.xrp_idr.sell
        numSell[173] = list4.tickers.xrphedge_idr.sell
        numSell[174] = list4.tickers.xsgd_idr.sell
        numSell[175] = list4.tickers.xtz_idr.sell
        numSell[176] = list4.tickers.xvs_idr.sell
        numSell[177] = list4.tickers.yfi_idr.sell
        numSell[178] = list4.tickers.yfii_idr.sell
        numSell[179] = list4.tickers.zec_idr.sell
        numSell[180] = list4.tickers.zil_idr.sell
        numSell[181] = list4.tickers.zrx_idr.sell
        numSell[182] = list4.tickers.btc_usdt.sell
        numSell[183] = list4.tickers.bear_usdt.sell
        numSell[184] = list4.tickers.bull_usdt.sell
        numSell[185] = list4.tickers.btt_usdt.sell
        numSell[186] = list4.tickers.eth_usdt.sell
        numSell[187] = list4.tickers.gard_usdt.sell
        numSell[188] = list4.tickers.kin_usdt.sell
        numSell[189] = list4.tickers.pundix_usdt.sell
        numSell[190] = list4.tickers.pxg_usdt.sell
        numSell[191] = list4.tickers.shib_usdt.sell
        numSell[192] = list4.tickers.ssp_usdt.sell
        numSell[193] = list4.tickers.xec_usdt.sell
    }

}