<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/battle">
        <html>
            <head>
                <meta charset="UTF-8"/>
                <meta name="viewport" content="initial-scale=1, maximum-scale=1" />
                <title>The Final Showdown: Battle of the Last Ones</title>
                <link rel="stylesheet" type="text/css" href="index.css"/> 
            </head>
            <body>
                <div class="table">
                    <section class="table_tit">
                        <h1>The Final Showdown: Battle of the Last Ones</h1>
                        <h5>The Epic Ten Legendary Warriors</h5>
                    </section>
                    <section class="table_bod">
                        <table>
                            <thead>
                                <tr>
                                    <th>Battle</th>
                                    <th>Player</th>
                                    <th>Ally Faction</th>
                                    <th>Ally Army</th>
                                    <th>Ally Troops (%)</th>
                                    <th>Enemy Faction</th>
                                    <th>Enemy army</th>
                                    <th>Enemy Troops (%)</th>
                                    <th>Battle Points</th>
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="row">
                                    <tr>
                                        <td><xsl:value-of select="battle_id"/></td>
                                        <td><xsl:value-of select="player_id"/></td>
                                        <td><xsl:value-of select="char_race"/></td>
                                        <td><xsl:value-of select="char_weap_army"/></td>
                                        <td><xsl:value-of select="allied_casualties"/></td>
                                        <td><xsl:value-of select="rival_race"/></td>
                                        <td><xsl:value-of select="rival_weap_army"/></td>
                                        <td><xsl:value-of select="enemy_casualties"/></td>
                                        <td><xsl:value-of select="battle_points"/></td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </table>
                    </section> 
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>