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
                    passing.jual = num[1][position]
                    passing.volume = num[2][position]
                    list.add(passing)
                }
                val adapter2 = bitcoinAdapter(list2,list)
                rvCrypto.adapter = adapter2
                //Always Aman
                adapter2.setOnclickListener(object : bitcoinAdapter.onItemClickListener{
                    override fun onItemclick(position: Int) {
                        val intent = Intent(this@Tabel,DetailCrypto::class.java)
                        intent.putExtra("nama",list2[position].description)
                        intent.putExtra("data",list2[position].trade_min_traded_currency)
                        intent.putExtra("pict",list2[position].url_logo_png)
                        intent.putExtra("beli",num[0][position])
                        intent.putExtra("jual",num[1][position])
                        intent.putExtra("vol", num[2][position])
                        startActivity(intent)
                    }
                })
            }
            override fun onFailure(call: Call<aaData>, t: Throwable) {
            }
        })
    }
    fun passingData(){
        num[0][0] = list4.tickers.component1().buy //btc_idr
        num[0][1] = list4.tickers.component2().buy //ten_idr
        num[0][2] = list4.tickers.component3().buy //1inch_idr
        num[0][3] = list4.tickers.component4().buy //aave_idr
        num[0][4] = list4.tickers.component5().buy //abbc_idr
        num[0][5] = list4.tickers.component6().buy //abyss_idr
        num[0][6] = list4.tickers.component7().buy //act_idr
        num[0][7] = list4.tickers.component8().buy //ada_idr
        num[0][8] = list4.tickers.component9().buy //aioz_idr
        num[0][9] = list4.tickers.component10().buy //alice_idr
        num[0][10] = list4.tickers.component11().buy //algo_idr
        num[0][11] = list4.tickers.component12().buy //alpaca_idr
        num[0][12] = list4.tickers.component13().buy //alt_idr
        num[0][13] = list4.tickers.component14().buy //amp_idr
        num[0][14] = list4.tickers.component15().buy //ankr_idr
        num[0][15] = list4.tickers.component16().buy //aoa_idr
        num[0][16] = list4.tickers.component17().buy //ata_idr
        num[0][17] = list4.tickers.component18().buy //atom_idr
        num[0][18] = list4.tickers.component19().buy //att_idr
        num[0][19] = list4.tickers.component20().buy //audio_idr
        num[0][20] = list4.tickers.component21().buy //axs_idr
        num[0][21] = list4.tickers.component22().buy //bake_idr
        num[0][22] = list4.tickers.component23().buy //bal_idr
        num[0][23] = list4.tickers.component24().buy //bat_idr
        num[0][24] = list4.tickers.component25().buy //bcd_idr
        num[0][25] = list4.tickers.component26().buy //bch_idr
        num[0][26] = list4.tickers.component27().buy //belt_idr
        num[0][27] = list4.tickers.component28().buy //bnb_idr
        num[0][28] = list4.tickers.component29().buy //bnbhedge_idr
        num[0][29] = list4.tickers.component30().buy //bnt_idr
        num[0][30] = list4.tickers.component31().buy //botx_idr
        num[0][31] = list4.tickers.component32().buy //bsv_idr
        num[0][32] = list4.tickers.component33().buy //btg_idr
        num[0][33] = list4.tickers.component34().buy //bts_idr
        num[0][34] = list4.tickers.component35().buy //busd_idr
        num[0][35] = list4.tickers.component36().buy //cake_idr
        num[0][36] = list4.tickers.component37().buy //cel_idr
        num[0][37] = list4.tickers.component38().buy //celo_idr
        num[0][38] = list4.tickers.component39().buy //chz_idr
        num[0][39] = list4.tickers.component40().buy //ckb_idr
        num[0][40] = list4.tickers.component41().buy //coal_idr
        num[0][41] = list4.tickers.component42().buy //comp_idr
        num[0][42] = list4.tickers.component43().buy //cfx_idr
        num[0][43] = list4.tickers.component44().buy //coti_idr
        num[0][44] = list4.tickers.component45().buy //cre_idr
        num[0][45] = list4.tickers.component46().buy //cro_idr
        num[0][46] = list4.tickers.component47().buy //crv_idr
        num[0][47] = list4.tickers.component48().buy //ctsi_idr
        num[0][48] = list4.tickers.component49().buy //dad_idr
        num[0][49] = list4.tickers.component50().buy //dai_idr
        num[0][50] = list4.tickers.component51().buy //dao_idr
        num[0][51] = list4.tickers.component52().buy //dash_idr
        num[0][52] = list4.tickers.component53().buy //dax_idr
        num[0][53] = list4.tickers.component54().buy //dent_idr
        num[0][54] = list4.tickers.component55().buy //dep_idr
        num[0][55] = list4.tickers.component56().buy //dgb_idr
        num[0][56] = list4.tickers.component57().buy //dgx_idr
        num[0][57] = list4.tickers.component58().buy //doge_idr
        num[0][58] = list4.tickers.component59().buy //dot_idr
        num[0][59] = list4.tickers.component60().buy //dvi_idr
        num[0][60] = list4.tickers.component61().buy //dydx_idr
        num[0][61] = list4.tickers.component62().buy //efi_idr
        num[0][62] = list4.tickers.component63().buy //egld_idr
        num[0][63] = list4.tickers.component64().buy //em_idr
        num[0][64] = list4.tickers.component65().buy //enj_idr
        num[0][65] = list4.tickers.component66().buy //eos_idr
        num[0][66] = list4.tickers.component67().buy //etc_idr
        num[0][67] = list4.tickers.component68().buy //eth_idr
        num[0][68] = list4.tickers.component69().buy //ethhedge_idr
        num[0][69] = list4.tickers.component70().buy //eurs_idr
        num[0][70] = list4.tickers.component71().buy //fil_idr
        num[0][71] = list4.tickers.component72().buy //firo_idr
        num[0][72] = list4.tickers.component73().buy //ftm_idr
        num[0][73] = list4.tickers.component74().buy //ftt_idr
        num[0][74] = list4.tickers.component75().buy //gala_idr
        num[0][75] = list4.tickers.component76().buy //glch_idr
        num[0][76] = list4.tickers.component77().buy //grt_idr
        num[0][77] = list4.tickers.component78().buy //gsc_idr
        num[0][78] = list4.tickers.component79().buy //gxc_idr
        num[0][79] = list4.tickers.component80().buy //hart_idr
        num[0][80] = list4.tickers.component81().buy //hbar_idr
        num[0][81] = list4.tickers.component82().buy //hedg_idr
        num[0][82] = list4.tickers.component83().buy //hedge_idr
        num[0][83] = list4.tickers.component84().buy //hibs_idr
        num[0][84] = list4.tickers.component85().buy //hive_idr
        num[0][85] = list4.tickers.component86().buy //hnst_idr
        num[0][86] = list4.tickers.component87().buy //hnt_idr
        num[0][87] = list4.tickers.component88().buy //hot_idr
        num[0][88] = list4.tickers.component89().buy //hpb_idr
        num[0][89] = list4.tickers.component90().buy //idk_idr
        num[0][90] = list4.tickers.component91().buy //ignis_idr
        num[0][91] = list4.tickers.component92().buy //inj_idr
        num[0][92] = list4.tickers.component93().buy //iost_idr
        num[0][93] = list4.tickers.component94().buy //iota_idr
        num[0][94] = list4.tickers.component95().buy //iotx_idr
        num[0][95] = list4.tickers.component96().buy //jst_idr
        num[0][96] = list4.tickers.component97().buy //kai_idr
        num[0][97] = list4.tickers.component98().buy //kdag_idr
        num[0][98] = list4.tickers.component99().buy //klay_idr
        num[0][99] = list4.tickers.component100().buy //ksm_idr
        num[0][100] = list4.tickers.component101().buy //let_idr
        num[0][101] = list4.tickers.component102().buy //lgold_idr
        num[0][102] = list4.tickers.component103().buy //link_idr
        num[0][103] = list4.tickers.component104().buy //lland_idr
        num[0][104] = list4.tickers.component105().buy //loom_idr
        num[0][105] = list4.tickers.component106().buy //lrc_idr
        num[0][106] = list4.tickers.component107().buy //lsilver_idr
        num[0][107] = list4.tickers.component108().buy //ltc_idr
        num[0][108] = list4.tickers.component109().buy //lyfe_idr
        num[0][109] = list4.tickers.component110().buy //mana_idr
        num[0][110] = list4.tickers.component111().buy //matic_idr
        num[0][111] = list4.tickers.component112().buy //mbl_idr
        num[0][112] = list4.tickers.component113().buy //mkr_idr
        num[0][113] = list4.tickers.component114().buy //near_idr
        num[0][114] = list4.tickers.component115().buy //neo_idr
        num[0][115] = list4.tickers.component116().buy //nexo_idr
        num[0][116] = list4.tickers.component117().buy //nrg_idr
        num[0][117] = list4.tickers.component118().buy //nxt_idr
        num[0][118] = list4.tickers.component119().buy //ocean_idr
        num[0][119] = list4.tickers.component120().buy //octo_idr
        num[0][120] = list4.tickers.component121().buy //ogn_idr
        num[0][121] = list4.tickers.component122().buy //okb_idr
        num[0][122] = list4.tickers.component123().buy //omg_idr
        num[0][123] = list4.tickers.component124().buy //ont_idr
        num[0][124] = list4.tickers.component125().buy //orbs_idr
        num[0][125] = list4.tickers.component126().buy //orc_idr
        num[0][126] = list4.tickers.component127().buy //oxt_idr
        num[0][127] = list4.tickers.component128().buy //pando_idr
        num[0][128] = list4.tickers.component129().buy //paxg_idr
        num[0][129] = list4.tickers.component130().buy //perp_idr
        num[0][130] = list4.tickers.component131().buy //qnt_idr
        num[0][131] = list4.tickers.component132().buy //qtum_idr
        num[0][132] = list4.tickers.component133().buy //ren_idr
        num[0][133] = list4.tickers.component134().buy //rep_idr
        num[0][134] = list4.tickers.component135().buy //rev_idr
        num[0][135] = list4.tickers.component136().buy //rvn_idr
        num[0][136] = list4.tickers.component137().buy //sand_idr
        num[0][137] = list4.tickers.component138().buy //sfi_idr
        num[0][138] = list4.tickers.component139().buy //slp_idr
        num[0][139] = list4.tickers.component140().buy //snx_idr
        num[0][140] = list4.tickers.component141().buy //sol_idr
        num[0][141] = list4.tickers.component142().buy //solve_idr
        num[0][142] = list4.tickers.component143().buy //srm_idr
        num[0][143] = list4.tickers.component144().buy //storj_idr
        num[0][144] = list4.tickers.component145().buy //sumo_idr
        num[0][145] = list4.tickers.component146().buy //sushi_idr
        num[0][146] = list4.tickers.component147().buy //sxp_idr
        num[0][147] = list4.tickers.component148().buy //tad_idr
        num[0][148] = list4.tickers.component149().buy //tel_idr
        num[0][149] = list4.tickers.component150().buy //tfuel_idr
        num[0][150] = list4.tickers.component151().buy //theta_idr
        num[0][151] = list4.tickers.component152().buy //titan_idr
        num[0][152] = list4.tickers.component153().buy //trx_idr
        num[0][153] = list4.tickers.component154().buy //uma_idr
        num[0][154] = list4.tickers.component155().buy //uni_idr
        num[0][155] = list4.tickers.component156().buy //usdc_idr
        num[0][156] = list4.tickers.component157().buy //usdp_idr
        num[0][157] = list4.tickers.component158().buy //usdt_idr
        num[0][158] = list4.tickers.component159().buy //velo_idr
        num[0][159] = list4.tickers.component160().buy //vex_idr
        num[0][160] = list4.tickers.component161().buy //vra_idr
        num[0][161] = list4.tickers.component162().buy //vsys_idr
        num[0][162] = list4.tickers.component163().buy //waves_idr
        num[0][163] = list4.tickers.component164().buy //wbtc_idr
        num[0][164] = list4.tickers.component165().buy //wnxm_idr
        num[0][165] = list4.tickers.component166().buy //wozx_idr
        num[0][166] = list4.tickers.component167().buy //xch_idr
        num[0][167] = list4.tickers.component168().buy //xdc_idr
        num[0][168] = list4.tickers.component169().buy //xem_idr
        num[0][169] = list4.tickers.component170().buy //xlm_idr
        num[0][170] = list4.tickers.component171().buy //xmr_idr
        num[0][171] = list4.tickers.component172().buy //xrp_idr
        num[0][172] = list4.tickers.component173().buy //xrphedge_idr
        num[0][173] = list4.tickers.component174().buy //xsgd_idr
        num[0][174] = list4.tickers.component175().buy //xtz_idr
        num[0][175] = list4.tickers.component176().buy //xvs_idr
        num[0][176] = list4.tickers.component177().buy //yfi_idr
        num[0][177] = list4.tickers.component178().buy //yfii_idr
        num[0][178] = list4.tickers.component179().buy //zec_idr
        num[0][179] = list4.tickers.component180().buy //zil_idr
        num[0][180] = list4.tickers.component181().buy //zrx_idr
        num[0][181] = list4.tickers.component182().buy //btc_usdt
        num[0][182] = list4.tickers.component183().buy //bear_usdt
        num[0][183] = list4.tickers.component184().buy //bull_usdt
        num[0][184] = list4.tickers.component185().buy //eth_usdt
        num[0][185] = list4.tickers.component186().buy //gard_usdt
        num[0][186] = list4.tickers.component187().buy //kin_usdt
        num[0][187] = list4.tickers.component188().buy //pundix_usdt
        num[0][188] = list4.tickers.component189().buy //pxg_usdt
        num[0][189] = list4.tickers.component190().buy //shib_usdt
        num[0][190] = list4.tickers.component191().buy //ssp_usdt
        num[0][191] = list4.tickers.component192().buy //xec_usdt
        num[1][0] = list4.tickers.component1().sell //btc_idr
        num[1][1] = list4.tickers.component2().sell //ten_idr
        num[1][2] = list4.tickers.component3().sell //1inch_idr
        num[1][3] = list4.tickers.component4().sell //aave_idr
        num[1][4] = list4.tickers.component5().sell //abbc_idr
        num[1][5] = list4.tickers.component6().sell //abyss_idr
        num[1][6] = list4.tickers.component7().sell //act_idr
        num[1][7] = list4.tickers.component8().sell //ada_idr
        num[1][8] = list4.tickers.component9().sell //aioz_idr
        num[1][9] = list4.tickers.component10().sell //alice_idr
        num[1][10] = list4.tickers.component11().sell //algo_idr
        num[1][11] = list4.tickers.component12().sell //alpaca_idr
        num[1][12] = list4.tickers.component13().sell //alt_idr
        num[1][13] = list4.tickers.component14().sell //amp_idr
        num[1][14] = list4.tickers.component15().sell //ankr_idr
        num[1][15] = list4.tickers.component16().sell //aoa_idr
        num[1][16] = list4.tickers.component17().sell //ata_idr
        num[1][17] = list4.tickers.component18().sell //atom_idr
        num[1][18] = list4.tickers.component19().sell //att_idr
        num[1][19] = list4.tickers.component20().sell //audio_idr
        num[1][20] = list4.tickers.component21().sell //axs_idr
        num[1][21] = list4.tickers.component22().sell //bake_idr
        num[1][22] = list4.tickers.component23().sell //bal_idr
        num[1][23] = list4.tickers.component24().sell //bat_idr
        num[1][24] = list4.tickers.component25().sell //bcd_idr
        num[1][25] = list4.tickers.component26().sell //bch_idr
        num[1][26] = list4.tickers.component27().sell //belt_idr
        num[1][27] = list4.tickers.component28().sell //bnb_idr
        num[1][28] = list4.tickers.component29().sell //bnbhedge_idr
        num[1][29] = list4.tickers.component30().sell //bnt_idr
        num[1][30] = list4.tickers.component31().sell //botx_idr
        num[1][31] = list4.tickers.component32().sell //bsv_idr
        num[1][32] = list4.tickers.component33().sell //btg_idr
        num[1][33] = list4.tickers.component34().sell //bts_idr
        num[1][34] = list4.tickers.component35().sell //busd_idr
        num[1][35] = list4.tickers.component36().sell //cake_idr
        num[1][36] = list4.tickers.component37().sell //cel_idr
        num[1][37] = list4.tickers.component38().sell //celo_idr
        num[1][38] = list4.tickers.component39().sell //chz_idr
        num[1][39] = list4.tickers.component40().sell //ckb_idr
        num[1][40] = list4.tickers.component41().sell //coal_idr
        num[1][41] = list4.tickers.component42().sell //comp_idr
        num[1][42] = list4.tickers.component43().sell //cfx_idr
        num[1][43] = list4.tickers.component44().sell //coti_idr
        num[1][44] = list4.tickers.component45().sell //cre_idr
        num[1][45] = list4.tickers.component46().sell //cro_idr
        num[1][46] = list4.tickers.component47().sell //crv_idr
        num[1][47] = list4.tickers.component48().sell //ctsi_idr
        num[1][48] = list4.tickers.component49().sell //dad_idr
        num[1][49] = list4.tickers.component50().sell //dai_idr
        num[1][50] = list4.tickers.component51().sell //dao_idr
        num[1][51] = list4.tickers.component52().sell //dash_idr
        num[1][52] = list4.tickers.component53().sell //dax_idr
        num[1][53] = list4.tickers.component54().sell //dent_idr
        num[1][54] = list4.tickers.component55().sell //dep_idr
        num[1][55] = list4.tickers.component56().sell //dgb_idr
        num[1][56] = list4.tickers.component57().sell //dgx_idr
        num[1][57] = list4.tickers.component58().sell //doge_idr
        num[1][58] = list4.tickers.component59().sell //dot_idr
        num[1][59] = list4.tickers.component60().sell //dvi_idr
        num[1][60] = list4.tickers.component61().sell //dydx_idr
        num[1][61] = list4.tickers.component62().sell //efi_idr
        num[1][62] = list4.tickers.component63().sell //egld_idr
        num[1][63] = list4.tickers.component64().sell //em_idr
        num[1][64] = list4.tickers.component65().sell //enj_idr
        num[1][65] = list4.tickers.component66().sell //eos_idr
        num[1][66] = list4.tickers.component67().sell //etc_idr
        num[1][67] = list4.tickers.component68().sell //eth_idr
        num[1][68] = list4.tickers.component69().sell //ethhedge_idr
        num[1][69] = list4.tickers.component70().sell //eurs_idr
        num[1][70] = list4.tickers.component71().sell //fil_idr
        num[1][71] = list4.tickers.component72().sell //firo_idr
        num[1][72] = list4.tickers.component73().sell //ftm_idr
        num[1][73] = list4.tickers.component74().sell //ftt_idr
        num[1][74] = list4.tickers.component75().sell //gala_idr
        num[1][75] = list4.tickers.component76().sell //glch_idr
        num[1][76] = list4.tickers.component77().sell //grt_idr
        num[1][77] = list4.tickers.component78().sell //gsc_idr
        num[1][78] = list4.tickers.component79().sell //gxc_idr
        num[1][79] = list4.tickers.component80().sell //hart_idr
        num[1][80] = list4.tickers.component81().sell //hbar_idr
        num[1][81] = list4.tickers.component82().sell //hedg_idr
        num[1][82] = list4.tickers.component83().sell //hedge_idr
        num[1][83] = list4.tickers.component84().sell //hibs_idr
        num[1][84] = list4.tickers.component85().sell //hive_idr
        num[1][85] = list4.tickers.component86().sell //hnst_idr
        num[1][86] = list4.tickers.component87().sell //hnt_idr
        num[1][87] = list4.tickers.component88().sell //hot_idr
        num[1][88] = list4.tickers.component89().sell //hpb_idr
        num[1][89] = list4.tickers.component90().sell //idk_idr
        num[1][90] = list4.tickers.component91().sell //ignis_idr
        num[1][91] = list4.tickers.component92().sell //inj_idr
        num[1][92] = list4.tickers.component93().sell //iost_idr
        num[1][93] = list4.tickers.component94().sell //iota_idr
        num[1][94] = list4.tickers.component95().sell //iotx_idr
        num[1][95] = list4.tickers.component96().sell //jst_idr
        num[1][96] = list4.tickers.component97().sell //kai_idr
        num[1][97] = list4.tickers.component98().sell //kdag_idr
        num[1][98] = list4.tickers.component99().sell //klay_idr
        num[1][99] = list4.tickers.component100().sell //ksm_idr
        num[1][100] = list4.tickers.component101().sell //let_idr
        num[1][101] = list4.tickers.component102().sell //lgold_idr
        num[1][102] = list4.tickers.component103().sell //link_idr
        num[1][103] = list4.tickers.component104().sell //lland_idr
        num[1][104] = list4.tickers.component105().sell //loom_idr
        num[1][105] = list4.tickers.component106().sell //lrc_idr
        num[1][106] = list4.tickers.component107().sell //lsilver_idr
        num[1][107] = list4.tickers.component108().sell //ltc_idr
        num[1][108] = list4.tickers.component109().sell //lyfe_idr
        num[1][109] = list4.tickers.component110().sell //mana_idr
        num[1][110] = list4.tickers.component111().sell //matic_idr
        num[1][111] = list4.tickers.component112().sell //mbl_idr
        num[1][112] = list4.tickers.component113().sell //mkr_idr
        num[1][113] = list4.tickers.component114().sell //near_idr
        num[1][114] = list4.tickers.component115().sell //neo_idr
        num[1][115] = list4.tickers.component116().sell //nexo_idr
        num[1][116] = list4.tickers.component117().sell //nrg_idr
        num[1][117] = list4.tickers.component118().sell //nxt_idr
        num[1][118] = list4.tickers.component119().sell //ocean_idr
        num[1][119] = list4.tickers.component120().sell //octo_idr
        num[1][120] = list4.tickers.component121().sell //ogn_idr
        num[1][121] = list4.tickers.component122().sell //okb_idr
        num[1][122] = list4.tickers.component123().sell //omg_idr
        num[1][123] = list4.tickers.component124().sell //ont_idr
        num[1][124] = list4.tickers.component125().sell //orbs_idr
        num[1][125] = list4.tickers.component126().sell //orc_idr
        num[1][126] = list4.tickers.component127().sell //oxt_idr
        num[1][127] = list4.tickers.component128().sell //pando_idr
        num[1][128] = list4.tickers.component129().sell //paxg_idr
        num[1][129] = list4.tickers.component130().sell //perp_idr
        num[1][130] = list4.tickers.component131().sell //qnt_idr
        num[1][131] = list4.tickers.component132().sell //qtum_idr
        num[1][132] = list4.tickers.component133().sell //ren_idr
        num[1][133] = list4.tickers.component134().sell //rep_idr
        num[1][134] = list4.tickers.component135().sell //rev_idr
        num[1][135] = list4.tickers.component136().sell //rvn_idr
        num[1][136] = list4.tickers.component137().sell //sand_idr
        num[1][137] = list4.tickers.component138().sell //sfi_idr
        num[1][138] = list4.tickers.component139().sell //slp_idr
        num[1][139] = list4.tickers.component140().sell //snx_idr
        num[1][140] = list4.tickers.component141().sell //sol_idr
        num[1][141] = list4.tickers.component142().sell //solve_idr
        num[1][142] = list4.tickers.component143().sell //srm_idr
        num[1][143] = list4.tickers.component144().sell //storj_idr
        num[1][144] = list4.tickers.component145().sell //sumo_idr
        num[1][145] = list4.tickers.component146().sell //sushi_idr
        num[1][146] = list4.tickers.component147().sell //sxp_idr
        num[1][147] = list4.tickers.component148().sell //tad_idr
        num[1][148] = list4.tickers.component149().sell //tel_idr
        num[1][149] = list4.tickers.component150().sell //tfuel_idr
        num[1][150] = list4.tickers.component151().sell //theta_idr
        num[1][151] = list4.tickers.component152().sell //titan_idr
        num[1][152] = list4.tickers.component153().sell //trx_idr
        num[1][153] = list4.tickers.component154().sell //uma_idr
        num[1][154] = list4.tickers.component155().sell //uni_idr
        num[1][155] = list4.tickers.component156().sell //usdc_idr
        num[1][156] = list4.tickers.component157().sell //usdp_idr
        num[1][157] = list4.tickers.component158().sell //usdt_idr
        num[1][158] = list4.tickers.component159().sell //velo_idr
        num[1][159] = list4.tickers.component160().sell //vex_idr
        num[1][160] = list4.tickers.component161().sell //vra_idr
        num[1][161] = list4.tickers.component162().sell //vsys_idr
        num[1][162] = list4.tickers.component163().sell //waves_idr
        num[1][163] = list4.tickers.component164().sell //wbtc_idr
        num[1][164] = list4.tickers.component165().sell //wnxm_idr
        num[1][165] = list4.tickers.component166().sell //wozx_idr
        num[1][166] = list4.tickers.component167().sell //xch_idr
        num[1][167] = list4.tickers.component168().sell //xdc_idr
        num[1][168] = list4.tickers.component169().sell //xem_idr
        num[1][169] = list4.tickers.component170().sell //xlm_idr
        num[1][170] = list4.tickers.component171().sell //xmr_idr
        num[1][171] = list4.tickers.component172().sell //xrp_idr
        num[1][172] = list4.tickers.component173().sell //xrphedge_idr
        num[1][173] = list4.tickers.component174().sell //xsgd_idr
        num[1][174] = list4.tickers.component175().sell //xtz_idr
        num[1][175] = list4.tickers.component176().sell //xvs_idr
        num[1][176] = list4.tickers.component177().sell //yfi_idr
        num[1][177] = list4.tickers.component178().sell //yfii_idr
        num[1][178] = list4.tickers.component179().sell //zec_idr
        num[1][179] = list4.tickers.component180().sell //zil_idr
        num[1][180] = list4.tickers.component181().sell //zrx_idr
        num[1][181] = list4.tickers.component182().sell //btc_usdt
        num[1][182] = list4.tickers.component183().sell //bear_usdt
        num[1][183] = list4.tickers.component184().sell //bull_usdt
        num[1][184] = list4.tickers.component185().sell //eth_usdt
        num[1][185] = list4.tickers.component186().sell //gard_usdt
        num[1][186] = list4.tickers.component187().sell //kin_usdt
        num[1][187] = list4.tickers.component188().sell //pundix_usdt
        num[1][188] = list4.tickers.component189().sell //pxg_usdt
        num[1][189] = list4.tickers.component190().sell //shib_usdt
        num[1][190] = list4.tickers.component191().sell //ssp_usdt
        num[1][191] = list4.tickers.component192().sell //xec_usdt
        num[2][0] = list4.tickers.component1().vol_idr //btc_idr
        num[2][1] = list4.tickers.component2().vol_idr //ten_idr
        num[2][2] = list4.tickers.component3().vol_idr //1inch_idr
        num[2][3] = list4.tickers.component4().vol_idr //aave_idr
        num[2][4] = list4.tickers.component5().vol_idr //abbc_idr
        num[2][5] = list4.tickers.component6().vol_idr //abyss_idr
        num[2][6] = list4.tickers.component7().vol_idr //act_idr
        num[2][7] = list4.tickers.component8().vol_idr //ada_idr
        num[2][8] = list4.tickers.component9().vol_idr //aioz_idr
        num[2][9] = list4.tickers.component10().vol_idr //alice_idr
        num[2][10] = list4.tickers.component11().vol_idr //algo_idr
        num[2][11] = list4.tickers.component12().vol_idr //alpaca_idr
        num[2][12] = list4.tickers.component13().vol_idr //alt_idr
        num[2][13] = list4.tickers.component14().vol_idr //amp_idr
        num[2][14] = list4.tickers.component15().vol_idr //ankr_idr
        num[2][15] = list4.tickers.component16().vol_idr //aoa_idr
        num[2][16] = list4.tickers.component17().vol_idr //ata_idr
        num[2][17] = list4.tickers.component18().vol_idr //atom_idr
        num[2][18] = list4.tickers.component19().vol_idr //att_idr
        num[2][19] = list4.tickers.component20().vol_idr //audio_idr
        num[2][20] = list4.tickers.component21().vol_idr //axs_idr
        num[2][21] = list4.tickers.component22().vol_idr //bake_idr
        num[2][22] = list4.tickers.component23().vol_idr //bal_idr
        num[2][23] = list4.tickers.component24().vol_idr //bat_idr
        num[2][24] = list4.tickers.component25().vol_idr //bcd_idr
        num[2][25] = list4.tickers.component26().vol_idr //bch_idr
        num[2][26] = list4.tickers.component27().vol_idr //belt_idr
        num[2][27] = list4.tickers.component28().vol_idr //bnb_idr
        num[2][28] = list4.tickers.component29().vol_idr //bnbhedge_idr
        num[2][29] = list4.tickers.component30().vol_idr //bnt_idr
        num[2][30] = list4.tickers.component31().vol_idr //botx_idr
        num[2][31] = list4.tickers.component32().vol_idr //bsv_idr
        num[2][32] = list4.tickers.component33().vol_idr //btg_idr
        num[2][33] = list4.tickers.component34().vol_idr //bts_idr
        num[2][34] = list4.tickers.component35().vol_idr //busd_idr
        num[2][35] = list4.tickers.component36().vol_idr //cake_idr
        num[2][36] = list4.tickers.component37().vol_idr //cel_idr
        num[2][37] = list4.tickers.component38().vol_idr //celo_idr
        num[2][38] = list4.tickers.component39().vol_idr //chz_idr
        num[2][39] = list4.tickers.component40().vol_idr //ckb_idr
        num[2][40] = list4.tickers.component41().vol_idr //coal_idr
        num[2][41] = list4.tickers.component42().vol_idr //comp_idr
        num[2][42] = list4.tickers.component43().vol_idr //cfx_idr
        num[2][43] = list4.tickers.component44().vol_idr //coti_idr
        num[2][44] = list4.tickers.component45().vol_idr //cre_idr
        num[2][45] = list4.tickers.component46().vol_idr //cro_idr
        num[2][46] = list4.tickers.component47().vol_idr //crv_idr
        num[2][47] = list4.tickers.component48().vol_idr //ctsi_idr
        num[2][48] = list4.tickers.component49().vol_idr //dad_idr
        num[2][49] = list4.tickers.component50().vol_idr //dai_idr
        num[2][50] = list4.tickers.component51().vol_idr //dao_idr
        num[2][51] = list4.tickers.component52().vol_idr //dash_idr
        num[2][52] = list4.tickers.component53().vol_idr //dax_idr
        num[2][53] = list4.tickers.component54().vol_idr //dent_idr
        num[2][54] = list4.tickers.component55().vol_idr //dep_idr
        num[2][55] = list4.tickers.component56().vol_idr //dgb_idr
        num[2][56] = list4.tickers.component57().vol_idr //dgx_idr
        num[2][57] = list4.tickers.component58().vol_idr //doge_idr
        num[2][58] = list4.tickers.component59().vol_idr //dot_idr
        num[2][59] = list4.tickers.component60().vol_idr //dvi_idr
        num[2][60] = list4.tickers.component61().vol_idr //dydx_idr
        num[2][61] = list4.tickers.component62().vol_idr //efi_idr
        num[2][62] = list4.tickers.component63().vol_idr //egld_idr
        num[2][63] = list4.tickers.component64().vol_idr //em_idr
        num[2][64] = list4.tickers.component65().vol_idr //enj_idr
        num[2][65] = list4.tickers.component66().vol_idr //eos_idr
        num[2][66] = list4.tickers.component67().vol_idr //etc_idr
        num[2][67] = list4.tickers.component68().vol_idr //eth_idr
        num[2][68] = list4.tickers.component69().vol_idr //ethhedge_idr
        num[2][69] = list4.tickers.component70().vol_idr //eurs_idr
        num[2][70] = list4.tickers.component71().vol_idr //fil_idr
        num[2][71] = list4.tickers.component72().vol_idr //firo_idr
        num[2][72] = list4.tickers.component73().vol_idr //ftm_idr
        num[2][73] = list4.tickers.component74().vol_idr //ftt_idr
        num[2][74] = list4.tickers.component75().vol_idr //gala_idr
        num[2][75] = list4.tickers.component76().vol_idr //glch_idr
        num[2][76] = list4.tickers.component77().vol_idr //grt_idr
        num[2][77] = list4.tickers.component78().vol_idr //gsc_idr
        num[2][78] = list4.tickers.component79().vol_idr //gxc_idr
        num[2][79] = list4.tickers.component80().vol_idr //hart_idr
        num[2][80] = list4.tickers.component81().vol_idr //hbar_idr
        num[2][81] = list4.tickers.component82().vol_idr //hedg_idr
        num[2][82] = list4.tickers.component83().vol_idr //hedge_idr
        num[2][83] = list4.tickers.component84().vol_idr //hibs_idr
        num[2][84] = list4.tickers.component85().vol_idr //hive_idr
        num[2][85] = list4.tickers.component86().vol_idr //hnst_idr
        num[2][86] = list4.tickers.component87().vol_idr //hnt_idr
        num[2][87] = list4.tickers.component88().vol_idr //hot_idr
        num[2][88] = list4.tickers.component89().vol_idr //hpb_idr
        num[2][89] = list4.tickers.component90().vol_idr //idk_idr
        num[2][90] = list4.tickers.component91().vol_idr //ignis_idr
        num[2][91] = list4.tickers.component92().vol_idr //inj_idr
        num[2][92] = list4.tickers.component93().vol_idr //iost_idr
        num[2][93] = list4.tickers.component94().vol_idr //iota_idr
        num[2][94] = list4.tickers.component95().vol_idr //iotx_idr
        num[2][95] = list4.tickers.component96().vol_idr //jst_idr
        num[2][96] = list4.tickers.component97().vol_idr //kai_idr
        num[2][97] = list4.tickers.component98().vol_idr //kdag_idr
        num[2][98] = list4.tickers.component99().vol_idr //klay_idr
        num[2][99] = list4.tickers.component100().vol_idr //ksm_idr
        num[2][100] = list4.tickers.component101().vol_idr //let_idr
        num[2][101] = list4.tickers.component102().vol_idr //lgold_idr
        num[2][102] = list4.tickers.component103().vol_idr //link_idr
        num[2][103] = list4.tickers.component104().vol_idr //lland_idr
        num[2][104] = list4.tickers.component105().vol_idr //loom_idr
        num[2][105] = list4.tickers.component106().vol_idr //lrc_idr
        num[2][106] = list4.tickers.component107().vol_idr //lsilver_idr
        num[2][107] = list4.tickers.component108().vol_idr //ltc_idr
        num[2][108] = list4.tickers.component109().vol_idr //lyfe_idr
        num[2][109] = list4.tickers.component110().vol_idr //mana_idr
        num[2][110] = list4.tickers.component111().vol_idr //matic_idr
        num[2][111] = list4.tickers.component112().vol_idr //mbl_idr
        num[2][112] = list4.tickers.component113().vol_idr //mkr_idr
        num[2][113] = list4.tickers.component114().vol_idr //near_idr
        num[2][114] = list4.tickers.component115().vol_idr //neo_idr
        num[2][115] = list4.tickers.component116().vol_idr //nexo_idr
        num[2][116] = list4.tickers.component117().vol_idr //nrg_idr
        num[2][117] = list4.tickers.component118().vol_idr //nxt_idr
        num[2][118] = list4.tickers.component119().vol_idr //ocean_idr
        num[2][119] = list4.tickers.component120().vol_idr //octo_idr
        num[2][120] = list4.tickers.component121().vol_idr //ogn_idr
        num[2][121] = list4.tickers.component122().vol_idr //okb_idr
        num[2][122] = list4.tickers.component123().vol_idr //omg_idr
        num[2][123] = list4.tickers.component124().vol_idr //ont_idr
        num[2][124] = list4.tickers.component125().vol_idr //orbs_idr
        num[2][125] = list4.tickers.component126().vol_idr //orc_idr
        num[2][126] = list4.tickers.component127().vol_idr //oxt_idr
        num[2][127] = list4.tickers.component128().vol_idr //pando_idr
        num[2][128] = list4.tickers.component129().vol_idr //paxg_idr
        num[2][129] = list4.tickers.component130().vol_idr //perp_idr
        num[2][130] = list4.tickers.component131().vol_idr //qnt_idr
        num[2][131] = list4.tickers.component132().vol_idr //qtum_idr
        num[2][132] = list4.tickers.component133().vol_idr //ren_idr
        num[2][133] = list4.tickers.component134().vol_idr //rep_idr
        num[2][134] = list4.tickers.component135().vol_idr //rev_idr
        num[2][135] = list4.tickers.component136().vol_idr //rvn_idr
        num[2][136] = list4.tickers.component137().vol_idr //sand_idr
        num[2][137] = list4.tickers.component138().vol_idr //sfi_idr
        num[2][138] = list4.tickers.component139().vol_idr //slp_idr
        num[2][139] = list4.tickers.component140().vol_idr //snx_idr
        num[2][140] = list4.tickers.component141().vol_idr //sol_idr
        num[2][141] = list4.tickers.component142().vol_idr //solve_idr
        num[2][142] = list4.tickers.component143().vol_idr //srm_idr
        num[2][143] = list4.tickers.component144().vol_idr //storj_idr
        num[2][144] = list4.tickers.component145().vol_idr //sumo_idr
        num[2][145] = list4.tickers.component146().vol_idr //sushi_idr
        num[2][146] = list4.tickers.component147().vol_idr //sxp_idr
        num[2][147] = list4.tickers.component148().vol_idr //tad_idr
        num[2][148] = list4.tickers.component149().vol_idr //tel_idr
        num[2][149] = list4.tickers.component150().vol_idr //tfuel_idr
        num[2][150] = list4.tickers.component151().vol_idr //theta_idr
        num[2][151] = list4.tickers.component152().vol_idr //titan_idr
        num[2][152] = list4.tickers.component153().vol_idr //trx_idr
        num[2][153] = list4.tickers.component154().vol_idr //uma_idr
        num[2][154] = list4.tickers.component155().vol_idr //uni_idr
        num[2][155] = list4.tickers.component156().vol_idr //usdc_idr
        num[2][156] = list4.tickers.component157().vol_idr //usdp_idr
        num[2][157] = list4.tickers.component158().vol_idr //usdt_idr
        num[2][158] = list4.tickers.component159().vol_idr //velo_idr
        num[2][159] = list4.tickers.component160().vol_idr //vex_idr
        num[2][160] = list4.tickers.component161().vol_idr //vra_idr
        num[2][161] = list4.tickers.component162().vol_idr //vsys_idr
        num[2][162] = list4.tickers.component163().vol_idr //waves_idr
        num[2][163] = list4.tickers.component164().vol_idr //wbtc_idr
        num[2][164] = list4.tickers.component165().vol_idr //wnxm_idr
        num[2][165] = list4.tickers.component166().vol_idr //wozx_idr
        num[2][166] = list4.tickers.component167().vol_idr //xch_idr
        num[2][167] = list4.tickers.component168().vol_idr //xdc_idr
        num[2][168] = list4.tickers.component169().vol_idr //xem_idr
        num[2][169] = list4.tickers.component170().vol_idr //xlm_idr
        num[2][170] = list4.tickers.component171().vol_idr //xmr_idr
        num[2][171] = list4.tickers.component172().vol_idr //xrp_idr
        num[2][172] = list4.tickers.component173().vol_idr //xrphedge_idr
        num[2][173] = list4.tickers.component174().vol_idr //xsgd_idr
        num[2][174] = list4.tickers.component175().vol_idr //xtz_idr
        num[2][175] = list4.tickers.component176().vol_idr //xvs_idr
        num[2][176] = list4.tickers.component177().vol_idr //yfi_idr
        num[2][177] = list4.tickers.component178().vol_idr //yfii_idr
        num[2][178] = list4.tickers.component179().vol_idr //zec_idr
        num[2][179] = list4.tickers.component180().vol_idr //zil_idr
        num[2][180] = list4.tickers.component181().vol_idr //zrx_idr
        num[2][181] = list4.tickers.component182().vol_usdt //btc_usdt
        num[2][182] = list4.tickers.component183().vol_usdt //bear_usdt
        num[2][183] = list4.tickers.component184().vol_usdt //bull_usdt
        num[2][184] = list4.tickers.component185().vol_usdt //eth_usdt
        num[2][185] = list4.tickers.component186().vol_usdt //gard_usdt
        num[2][186] = list4.tickers.component187().vol_usdt //kin_usdt
        num[2][187] = list4.tickers.component188().vol_usdt //pundix_usdt
        num[2][188] = list4.tickers.component189().vol_usdt //pxg_usdt
        num[2][189] = list4.tickers.component190().vol_usdt //shib_usdt
        num[2][190] = list4.tickers.component191().vol_usdt //ssp_usdt
        num[2][191] = list4.tickers.component192().vol_usdt //xec_usdt


    }

}