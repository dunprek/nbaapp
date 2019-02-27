package don.com.nbaapp.model

import com.google.gson.annotations.SerializedName

data class ScoreBoardMdl(
        @SerializedName("_internal")
        val `internal`: Internal?,
        val numGames: Int?, // 3
        val games: List<Game>
) {
    data class Internal(
            val pubDateTime: String?, // 2019-02-27 04:16:19.535
            val xslt: String?, // xsl/league/schedule/marty_daily_scoreboard.xsl
            val eventName: String? // lp_video_game_changed_for_date
    )

    data class Game(
            val seasonStageId: Int?, // 2
            val seasonYear: String?, // 2018
            val gameId: String?, // 0021800910
            val arena: Arena?,
            val isGameActivated: Boolean?, // false
            val statusNum: Int?, // 3
            val extendedStatusNum: Int?, // 0
            val startTimeEastern: String?, // 10:30 PM ET
            val startTimeUTC: String?, // 2019-02-27T03:30:00.000Z
            val endTimeUTC: String?, // 2019-02-27T06:13:00.000Z
            val startDateEastern: String?, // 20190226
            val clock: String?,
            val isBuzzerBeater: Boolean?, // false
            val isPreviewArticleAvail: Boolean?, // true
            val isRecapArticleAvail: Boolean?, // true
            val tickets: Tickets?,
            val hasGameBookPdf: Boolean?, // true
            val isStartTimeTBD: Boolean?, // false
            val nugget: Nugget?,
            val attendance: String?, // 18378
            val gameDuration: GameDuration?,
            val period: Period?,
            val vTeam: VTeam?,
            val hTeam: HTeam?,
            val watch: Watch?
    ) {
        data class HTeam(
                val teamId: String?, // 1610612743
                val triCode: String?, // DEN
                val win: String?, // 42
                val loss: String?, // 18
                val seriesWin: String?, // 2
                val seriesLoss: String?, // 0
                val score: String?, // 121
                val linescore: List<Linescore?>?
        ) {
            data class Linescore(
                    val score: String? // 30
            )
        }

        data class GameDuration(
                val hours: String?, // 2
                val minutes: String? // 32
        )

        data class VTeam(
                val teamId: String?, // 1610612760
                val triCode: String?, // OKC
                val win: String?, // 38
                val loss: String?, // 22
                val seriesWin: String?, // 0
                val seriesLoss: String?, // 2
                val score: String?, // 112
                val linescore: List<Linescore?>?
        ) {
            data class Linescore(
                    val score: String? // 34
            )
        }

        data class Nugget(
                val text: String? // Jokic: 36 points, 9 rebounds, 10 assists
        )

        data class Watch(
                val broadcast: Broadcast?
        ) {
            data class Broadcast(
                    val broadcasters: Broadcasters?,
                    val video: Video?,
                    val audio: Audio?
            ) {
                data class Broadcasters(
                        val national: List<National?>?,
                        val canadian: List<Canadian?>?,
                        val vTeam: List<VTeam?>?,
                        val hTeam: List<Any?>?,
                        @SerializedName("spanish_hTeam")
                        val spanishHTeam: List<Any?>?,
                        @SerializedName("spanish_vTeam")
                        val spanishVTeam: List<Any?>?,
                        @SerializedName("spanish_national")
                        val spanishNational: List<Any?>?
                ) {
                    data class VTeam(
                            val shortName: String?, // FSOK
                            val longName: String? // Fox Sports Oklahoma
                    )

                    data class Canadian(
                            val shortName: String?, // SN1
                            val longName: String? // SN1
                    )

                    data class National(
                            val shortName: String?, // TNT
                            val longName: String? // Turner Networks
                    )
                }

                data class Audio(
                        val national: National?,
                        val vTeam: VTeam?,
                        val hTeam: HTeam?
                ) {
                    data class VTeam(
                            val streams: List<Stream?>?,
                            val broadcasters: List<Broadcaster?>?
                    ) {
                        data class Broadcaster(
                                val shortName: String?, // WWLS 98.1FM OKC
                                val longName: String? // WWLS 98.1FM OKC
                        )

                        data class Stream(
                                val language: String?, // Spanish
                                val isOnAir: Boolean?, // false
                                val streamId: String?
                        )
                    }

                    data class National(
                            val streams: List<Stream?>?,
                            val broadcasters: List<Any?>?
                    ) {
                        data class Stream(
                                val language: String?, // Spanish
                                val isOnAir: Boolean?, // false
                                val streamId: String?
                        )
                    }

                    data class HTeam(
                            val streams: List<Stream?>?,
                            val broadcasters: List<Broadcaster?>?
                    ) {
                        data class Stream(
                                val language: String?, // Spanish
                                val isOnAir: Boolean?, // false
                                val streamId: String?
                        )

                        data class Broadcaster(
                                val shortName: String?, // KKSE-FM 92.5/KKSE 950
                                val longName: String? // KKSE-FM 92.5/KKSE 950
                        )
                    }
                }

                data class Video(
                        val regionalBlackoutCodes: String?, // torr_okcr
                        val canPurchase: Boolean?, // true
                        val isLeaguePass: Boolean?, // true
                        val isNationalBlackout: Boolean?, // false
                        val isTNTOT: Boolean?, // false
                        val isVR: Boolean?, // false
                        val tntotIsOnAir: Boolean?, // false
                        val isNextVR: Boolean?, // false
                        val isNBAOnTNTVR: Boolean?, // false
                        val isMagicLeap: Boolean?, // false
                        val isOculusVenues: Boolean?, // false
                        val streams: List<Stream?>?,
                        val deepLink: List<DeepLink?>?
                ) {
                    data class Stream(
                            val streamType: String?, // condensed
                            val isOnAir: Boolean?, // false
                            val doesArchiveExist: Boolean?, // true
                            val isArchiveAvailToWatch: Boolean?, // true
                            val streamId: String?, // 100218009101030
                            val duration: Int? // 0
                    )

                    data class DeepLink(
                            val broadcaster: String?, // TNT
                            val regionalMarketCodes: String?,
                            val iosApp: String?, // http://www.tntdrama.com/watchtnt/
                            val androidApp: String?, // http://www.tntdrama.com/watchtnt/
                            val desktopWeb: String?, // http://www.tntdrama.com/watchtnt/
                            val mobileWeb: String? // http://www.tntdrama.com/watchtnt/
                    )
                }
            }
        }

        data class Tickets(
                val mobileApp: String?, // https://a.data.nba.com/tickets/single/2018/0021800910/APP_TIX
                val desktopWeb: String?, // https://a.data.nba.com/tickets/single/2018/0021800910/TEAM_SCH
                val mobileWeb: String?, // https://a.data.nba.com/tickets/single/2018/0021800910/WEB_MWEB
                val leagGameInfo: String?, // https://a.data.nba.com/tickets/single/2018/0021800910/LEAG_GAMEINFO
                val leagTix: String? // https://a.data.nba.com/tickets/single/2018/0021800910/LEAG_TIX
        )

        data class Arena(
                val name: String, // Pepsi Center
                val isDomestic: Boolean?, // true
                val city: String?, // Denver
                val stateAbbr: String?, // CO
                val country: String? // USA
        )

        data class Period(
                val current: Int?, // 4
                val type: Int?, // 0
                val maxRegular: Int?, // 4
                val isHalftime: Boolean?, // false
                val isEndOfPeriod: Boolean? // false
        )
    }
}