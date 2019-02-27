package don.com.nbaapp.model

import com.google.gson.annotations.SerializedName

data class BaseMdl(
        @SerializedName("_internal")
        val `internal`: Internal?,
        val seasonScheduleYear: Int?, // 2018
        val showPlayoffsClinch: Boolean?, // false
        val links: Links?
) {
    data class Internal(
            val pubDateTime: String?, // 2019-02-26 12:00:00.49
            val xslt: String?, // xsl/league/schedule/marty_today.xsl
            val eventName: String? // noon_roll
    )

    data class Links(
            val anchorDate: String?, // 20190226
            val currentDate: String?, // 20190226
            val calendar: String?, // /prod/v2/calendar.json
            val todayScoreboard: String?, // /prod/v2/20190226/scoreboard.json
            val currentScoreboard: String?, // /prod/v2/20190226/scoreboard.json
            val scoreboard: String?, // /prod/v2/{{gameDate}}/scoreboard.json
            val teams: String?, // /prod/v2/2018/teams.json
            val leagueRosterPlayers: String?, // /prod/v1/2018/players.json
            val allstarRoster: String?, // /prod/v1/allstar/2018/AS_roster.json
            val leagueRosterCoaches: String?, // /prod/v1/2018/coaches.json
            val leagueSchedule: String?, // /prod/v1/2018/schedule.json
            val leagueConfStandings: String?, // /prod/v1/current/standings_conference.json
            val leagueDivStandings: String?, // /prod/v1/current/standings_division.json
            val leagueUngroupedStandings: String?, // /prod/v1/current/standings_all.json
            val leagueMiniStandings: String?, // /prod/v1/current/standings_all_no_sort_keys.json
            val leagueTeamStatsLeaders: String?, // /prod/v1/2018/team_stats_rankings.json
            val leagueLastFiveGameTeamStats: String?, // /prod/v1/2018/team_stats_last_five_games.json
            val previewArticle: String?, // /prod/v1/{{gameDate}}/{{gameId}}_preview_article.json
            val recapArticle: String?, // /prod/v1/{{gameDate}}/{{gameId}}_recap_article.json
            val gameBookPdf: String?, // /prod/v1/{{gameDate}}/{{gameId}}_Book.pdf
            val boxscore: String?, // /prod/v1/{{gameDate}}/{{gameId}}_boxscore.json
            val miniBoxscore: String?, // /prod/v1/{{gameDate}}/{{gameId}}_mini_boxscore.json
            val pbp: String?, // /prod/v1/{{gameDate}}/{{gameId}}_pbp_{{periodNum}}.json
            val leadTracker: String?, // /prod/v1/{{gameDate}}/{{gameId}}_lead_tracker_{{periodNum}}.json
            val playerGameLog: String?, // /prod/v1/2018/players/{{personId}}_gamelog.json
            val playerProfile: String?, // /prod/v1/2018/players/{{personId}}_profile.json
            val playerUberStats: String?, // /prod/v1/2018/players/{{personId}}_uber_stats.json
            val teamSchedule: String?, // /prod/v1/2018/teams/{{teamUrlCode}}/schedule.json
            val teamsConfig: String?, // /prod/2018/teams_config.json
            val teamRoster: String?, // /prod/v1/2018/teams/{{teamUrlCode}}/roster.json
            val teamsConfigYear: String?, // /prod/{{seasonScheduleYear}}/teams_config.json
            val teamScheduleYear: String?, // /prod/v1/{{seasonScheduleYear}}/teams/{{teamUrlCode}}/schedule.json
            val teamLeaders: String?, // /prod/v1/2018/teams/{{teamUrlCode}}/leaders.json
            val teamScheduleYear2: String?, // /prod/v1/{{seasonScheduleYear}}/teams/{{teamId}}/schedule.json
            val teamLeaders2: String?, // /prod/v1/2018/teams/{{teamId}}/leaders.json
            val playoffsBracket: String?, // /prod/v1/2017/playoffsBracket.json
            val playoffSeriesLeaders: String? // /prod/v1/2018/playoffs_{{seriesId}}_leaders.json
    )
}