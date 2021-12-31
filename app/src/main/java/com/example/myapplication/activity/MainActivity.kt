package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.myapplication.R
import com.example.myapplication.adapter.bitcoinAdapter
import com.example.myapplication.adapter.realAdapter
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


class MainActivity : AppCompatActivity() {
    //buat recyler view nih ingat woy
    lateinit var rvCrypto: RecyclerView
    var list2 = ArrayList<srcGambarItem>()
    lateinit var list4 : aaData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCrypto = findViewById(R.id.rvCrypto)
        rvCrypto.setHasFixedSize(true)
        rvCrypto.layoutManager = LinearLayoutManager(this)
        showContent()
        val gambar = findViewById<ImageView>(R.id.cek)
        Picasso.get()
            .load("https://indodax.com/v2/logo/png/color/btc.png")
            .into(gambar);

    }



    fun showContent() {
        var ex = findViewById<TextView>(R.id.ex)
        var k = ""

        //kalau array pakai ini
        RetrofitClient.instance.getDatag().enqueue(object : Callback<ArrayList<srcGambarItem>>{
            override fun onResponse(call: Call<ArrayList<srcGambarItem>>, response: Response<ArrayList<srcGambarItem>>) {
                val listkan = response?.body()
                list2 = listkan!!


            }

            override fun onFailure(call: Call<ArrayList<srcGambarItem>>, t: Throwable) {
                ex.text = "hahahah"
            }



        })
        RetrofitClient.instance.getDatah().enqueue(object : Callback<aaData>{
            override fun onResponse(call: Call<aaData>, response: Response<aaData>) {
                val listyuk = response?.body()
                list4 = listyuk!!
//                for(data in Tickers::class.memberProperties)
//                    k += data

                var num = Array(200){""}
                num[0] = list4.tickers.btc_idr.buy
                num[1] = list4.tickers.ten_idr.buy
                num[2] = list4.tickers.component3().buy
                num[3] = list4.tickers.aave_idr.buy
                num[4] = list4.tickers.abbc_idr.buy
                num[5] = list4.tickers.abyss_idr.buy
                num[6] = list4.tickers.act_idr.buy
                num[7] = list4.tickers.ada_idr.buy
                num[8] = list4.tickers.aioz_idr.buy
                num[9] = list4.tickers.alice_idr.buy
                num[10] = list4.tickers.algo_idr.buy
                num[11] = list4.tickers.alpaca_idr.buy
                num[12] = list4.tickers.alt_idr.buy
                num[13] = list4.tickers.amp_idr.buy
                num[14] = list4.tickers.ankr_idr.buy
                num[15] = list4.tickers.aoa_idr.buy
                num[16] = list4.tickers.ata_idr.buy
                num[17] = list4.tickers.atom_idr.buy
                num[18] = list4.tickers.att_idr.buy
                num[19] = list4.tickers.audio_idr.buy
                num[20] = list4.tickers.axs_idr.buy
                num[21] = list4.tickers.bake_idr.buy
                num[22] = list4.tickers.bal_idr.buy
                num[23] = list4.tickers.bat_idr.buy
                num[24] = list4.tickers.bcd_idr.buy
                num[25] = list4.tickers.bch_idr.buy
                num[26] = list4.tickers.belt_idr.buy
                num[27] = list4.tickers.bnb_idr.buy
                num[28] = list4.tickers.bnbhedge_idr.buy
                num[29] = list4.tickers.bnt_idr.buy
                num[30] = list4.tickers.botx_idr.buy
                num[31] = list4.tickers.bsv_idr.buy
                num[32] = list4.tickers.btg_idr.buy
                num[33] = list4.tickers.bts_idr.buy
                num[34] = list4.tickers.btt_idr.buy
                num[35] = list4.tickers.busd_idr.buy
                num[36] = list4.tickers.cake_idr.buy
                num[37] = list4.tickers.cel_idr.buy
                num[38] = list4.tickers.celo_idr.buy
                num[39] = list4.tickers.chz_idr.buy
                num[40] = list4.tickers.ckb_idr.buy
                num[41] = list4.tickers.coal_idr.buy
                num[42] = list4.tickers.comp_idr.buy
                num[43] = list4.tickers.cfx_idr.buy
                num[44] = list4.tickers.coti_idr.buy
                num[45] = list4.tickers.cre_idr.buy
                num[46] = list4.tickers.cro_idr.buy
                num[47] = list4.tickers.crv_idr.buy
                num[48] = list4.tickers.ctsi_idr.buy
                num[49] = list4.tickers.dad_idr.buy
                num[50] = list4.tickers.dai_idr.buy
                num[51] = list4.tickers.dao_idr.buy
                num[52] = list4.tickers.dash_idr.buy
                num[53] = list4.tickers.dax_idr.buy
                num[54] = list4.tickers.dent_idr.buy
                num[55] = list4.tickers.dep_idr.buy
                num[56] = list4.tickers.dgb_idr.buy
                num[57] = list4.tickers.dgx_idr.buy
                num[58] = list4.tickers.doge_idr.buy
                num[59] = list4.tickers.dot_idr.buy
                num[60] = list4.tickers.dvi_idr.buy
                num[61] = list4.tickers.dydx_idr.buy
                num[62] = list4.tickers.efi_idr.buy
                num[63] = list4.tickers.egld_idr.buy
                num[64] = list4.tickers.em_idr.buy
                num[65] = list4.tickers.enj_idr.buy
                num[66] = list4.tickers.eos_idr.buy
                num[67] = list4.tickers.etc_idr.buy
                num[68] = list4.tickers.eth_idr.buy
                num[69] = list4.tickers.ethhedge_idr.buy
                num[70] = list4.tickers.eurs_idr.buy
                num[71] = list4.tickers.fil_idr.buy
                num[72] = list4.tickers.firo_idr.buy
                num[73] = list4.tickers.ftm_idr.buy
                num[74] = list4.tickers.ftt_idr.buy
                num[75] = list4.tickers.gala_idr.buy
                num[76] = list4.tickers.glch_idr.buy
                num[77] = list4.tickers.grt_idr.buy
                num[78] = list4.tickers.gsc_idr.buy
                num[79] = list4.tickers.gxc_idr.buy
                num[80] = list4.tickers.hart_idr.buy
                num[81] = list4.tickers.hbar_idr.buy
                num[82] = list4.tickers.hedg_idr.buy
                num[83] = list4.tickers.hedge_idr.buy
                num[84] = list4.tickers.hibs_idr.buy
                num[85] = list4.tickers.hive_idr.buy
                num[86] = list4.tickers.hnst_idr.buy
                num[87] = list4.tickers.hnt_idr.buy
                num[88] = list4.tickers.hot_idr.buy
                num[89] = list4.tickers.hpb_idr.buy
                num[90] = list4.tickers.idk_idr.buy
                num[91] = list4.tickers.ignis_idr.buy
                num[92] = list4.tickers.inj_idr.buy
                num[93] = list4.tickers.iost_idr.buy
                num[94] = list4.tickers.iota_idr.buy
                num[95] = list4.tickers.iotx_idr.buy
                num[96] = list4.tickers.jst_idr.buy
                num[97] = list4.tickers.kai_idr.buy
                num[98] = list4.tickers.kdag_idr.buy
                num[99] = list4.tickers.klay_idr.buy
                num[100] = list4.tickers.ksm_idr.buy
                num[101] = list4.tickers.let_idr.buy
                num[102] = list4.tickers.lgold_idr.buy
                num[103] = list4.tickers.link_idr.buy
                num[104] = list4.tickers.lland_idr.buy
                num[105] = list4.tickers.loom_idr.buy
                num[106] = list4.tickers.lrc_idr.buy
                num[107] = list4.tickers.lsilver_idr.buy
                num[108] = list4.tickers.ltc_idr.buy
                num[109] = list4.tickers.lyfe_idr.buy
                num[110] = list4.tickers.mana_idr.buy
                num[111] = list4.tickers.matic_idr.buy
                num[112] = list4.tickers.mbl_idr.buy
                num[113] = list4.tickers.mkr_idr.buy
                num[114] = list4.tickers.near_idr.buy
                num[115] = list4.tickers.neo_idr.buy
                num[116] = list4.tickers.nexo_idr.buy
                num[117] = list4.tickers.nrg_idr.buy
                num[118] = list4.tickers.nxt_idr.buy
                num[119] = list4.tickers.ocean_idr.buy
                num[120] = list4.tickers.octo_idr.buy
                num[121] = list4.tickers.ogn_idr.buy
                num[122] = list4.tickers.okb_idr.buy
                num[123] = list4.tickers.omg_idr.buy
                num[124] = list4.tickers.ont_idr.buy
                num[125] = list4.tickers.orbs_idr.buy
                num[126] = list4.tickers.orc_idr.buy
                num[127] = list4.tickers.oxt_idr.buy
                num[128] = list4.tickers.pando_idr.buy
                num[129] = list4.tickers.paxg_idr.buy
                num[130] = list4.tickers.perp_idr.buy
                num[131] = list4.tickers.qnt_idr.buy
                num[132] = list4.tickers.qtum_idr.buy
                num[133] = list4.tickers.ren_idr.buy
                num[134] = list4.tickers.rep_idr.buy
                num[135] = list4.tickers.rev_idr.buy
                num[136] = list4.tickers.rvn_idr.buy
                num[137] = list4.tickers.sand_idr.buy
                num[138] = list4.tickers.sfi_idr.buy
                num[139] = list4.tickers.slp_idr.buy
                num[140] = list4.tickers.snx_idr.buy
                num[141] = list4.tickers.sol_idr.buy
                num[142] = list4.tickers.solve_idr.buy
                num[143] = list4.tickers.srm_idr.buy
                num[144] = list4.tickers.storj_idr.buy
                num[145] = list4.tickers.sumo_idr.buy
                num[146] = list4.tickers.sushi_idr.buy
                num[147] = list4.tickers.sxp_idr.buy
                num[148] = list4.tickers.tad_idr.buy
                num[149] = list4.tickers.tel_idr.buy
                num[150] = list4.tickers.tfuel_idr.buy
                num[151] = list4.tickers.theta_idr.buy
                num[152] = list4.tickers.titan_idr.buy
                num[153] = list4.tickers.trx_idr.buy
                num[154] = list4.tickers.uma_idr.buy
                num[155] = list4.tickers.uni_idr.buy
                num[156] = list4.tickers.usdc_idr.buy
                num[157] = list4.tickers.usdp_idr.buy
                num[158] = list4.tickers.usdt_idr.buy
                num[159] = list4.tickers.velo_idr.buy
                num[160] = list4.tickers.vex_idr.buy
                num[161] = list4.tickers.vra_idr.buy
                num[162] = list4.tickers.vsys_idr.buy
                num[163] = list4.tickers.waves_idr.buy
                num[164] = list4.tickers.wbtc_idr.buy
                num[165] = list4.tickers.wnxm_idr.buy
                num[166] = list4.tickers.wozx_idr.buy
                num[167] = list4.tickers.xch_idr.buy
                num[168] = list4.tickers.xdc_idr.buy
                num[169] = list4.tickers.xem_idr.buy
                num[170] = list4.tickers.xlm_idr.buy
                num[171] = list4.tickers.xmr_idr.buy
                num[172] = list4.tickers.xrp_idr.buy
                num[173] = list4.tickers.xrphedge_idr.buy
                num[174] = list4.tickers.xsgd_idr.buy
                num[175] = list4.tickers.xtz_idr.buy
                num[176] = list4.tickers.xvs_idr.buy
                num[177] = list4.tickers.yfi_idr.buy
                num[178] = list4.tickers.yfii_idr.buy
                num[179] = list4.tickers.zec_idr.buy
                num[180] = list4.tickers.zil_idr.buy
                num[181] = list4.tickers.zrx_idr.buy
                num[182] = list4.tickers.btc_usdt.buy
                num[183] = list4.tickers.bear_usdt.buy
                num[184] = list4.tickers.bull_usdt.buy
                num[185] = list4.tickers.btt_usdt.buy
                num[186] = list4.tickers.eth_usdt.buy
                num[187] = list4.tickers.gard_usdt.buy
                num[188] = list4.tickers.kin_usdt.buy
                num[189] = list4.tickers.pundix_usdt.buy
                num[190] = list4.tickers.pxg_usdt.buy
                num[191] = list4.tickers.shib_usdt.buy
                num[192] = list4.tickers.ssp_usdt.buy
                num[193] = list4.tickers.xec_usdt.buy

                val sayang = passingBuy()
                val list = arrayListOf<passingBuy>()
                for(position in num.indices) {
                    val passing = passingBuy()
                    passing.harga = num[position]
                    list.add(passing)
                }


                ex.text = k
                val adapter2 = bitcoinAdapter(list2,list)
                rvCrypto.adapter = adapter2

            }

            override fun onFailure(call: Call<aaData>, t: Throwable) {
                ex.text = "error nih boss senggol dong"
            }

        })
    }

}