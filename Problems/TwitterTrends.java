package Problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TwitterTrends {
    public static void main(String[] args) {
        List<String> tweets = Arrays.asList("Donald Trump becomes the 45th #US President",
                "Potentially habitable exoplanet #ProximaB discovered", "#RogerFederer wins #US Open for 5th time",
                "#GravitationalWaves detection successful", "Traces of liquid water discovered on #Mars",
                "Life Could Survive on Exoplanet #ProximaB", "Go go #RogerFederer",
                "Ten ways #ProximaB is different from Earth", "ISRO becomes 4th space agency to reach #Mars",
                "#RogerFederer beats #Nadal", "Donald Trump becomes the 45th #US1 President",
                "Potentially habitable exoplanet #ProximaB6 discovered", "#RogerFederer wins #US2 Open for 5th time",
                "#GravitationalWaves detection successful", "Traces of liquid water discovered on #Mars4",
                "Life Could Survive on Exoplanet #ProximaB9", "Go go #RogerFederer3",
                "Ten ways #ProximaB is different from Earth", "ISRO becomes 4th space agency to reach #Mars6",
                "#RogerFederer beats #Nadal");

        HashTag ht = new HashTag();
        for (String tweet : tweets) {
            ht.findHashsFromTweet(tweet);
        }
        System.out.println("Trending hashTags : " + ht.getTrendingHashtags());
    }
}

class HashTag {
    static private Map<String, Integer> hashTagMap = new HashMap<>();
    private Pattern pattern = Pattern.compile("#[a-zA-Z]*", Pattern.CASE_INSENSITIVE);

    public void findHashsFromTweet(String tweet) {
        Matcher matcher = pattern.matcher(tweet);
        while (matcher.find()) {
            String hTag = matcher.group();
            if (hashTagMap.get(hTag) != null)
                hashTagMap.put(hTag, hashTagMap.get(hTag) + 1);
            else
                hashTagMap.put(hTag, 1);
        }
    }

    public Set<String> getTrendingHashtags() {
        final Map<String, Integer> trendingHashtags = hashTagMap.entrySet().stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed())).limit(10)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return trendingHashtags.keySet();
    }

}
