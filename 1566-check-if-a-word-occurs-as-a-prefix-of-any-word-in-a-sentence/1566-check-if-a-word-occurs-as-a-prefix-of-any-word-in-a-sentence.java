class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) 
    {
        String[] ch=sentence.split(" ");

        for(int i=0;i<ch.length;i++)
        {
            if(ch[i].startsWith(searchWord))
              return i+1;
        }
        return -1;
    }
}